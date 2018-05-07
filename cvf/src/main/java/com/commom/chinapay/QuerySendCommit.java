package com.commom.chinapay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import chinapay.Base64;
import chinapay.PrivateKey;
import chinapay.SecureLink;

public class QuerySendCommit extends HttpServlet {
	
	
	public static boolean chinapayCommit(Map<String, String> parMap,String merchantId, String msg) throws Exception {
		
		//AppService appService = new AppService();

		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setParameter(
				HttpMethodParams.HTTP_CONTENT_CHARSET, "GBK");
		String url = Config.SinPay_url;
		PostMethod postMethod = new PostMethod(url);

		// 填入各个表单域的值
		NameValuePair[] data = {
				new NameValuePair("merId", parMap.get("merId")),
				new NameValuePair("merDate", parMap.get("merDate")),
				new NameValuePair("merSeqId", parMap.get("merSeqId")),
				new NameValuePair("version", parMap.get("version")),
				new NameValuePair("chkValue", parMap.get("chkValue")),
				new NameValuePair("signFlag", parMap.get("signFlag")) };

		// 将表单的值放入postMethod中
		postMethod.setRequestBody(data);
		// 执行postMethod
		try {
			httpClient.executeMethod(postMethod);
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 读取内容
		InputStream resInputStream = null;
		try {
			resInputStream = postMethod.getResponseBodyAsStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 处理内容
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				resInputStream));
		String tempBf = null;
		StringBuffer html = new StringBuffer();
		while ((tempBf = reader.readLine()) != null) {

			html.append(tempBf);
		}
		String resMes = html.toString();
		int dex = resMes.lastIndexOf("|");
		String Res_Code = resMes.substring(0, 3);

		// 提取返回数据
		if (Res_Code.equals("000")) {//000表示成功。001表示没有记录。002表示查询出错。查询频率超限也为002
			String Res_stat = resMes.substring(dex - 2, dex - 1);
			String Res_chkValue = resMes.substring(dex + 1);

			String plainData = resMes.substring(0, dex + 1);
			String Data = new String(Base64.encode(plainData.getBytes()));
			String str[]=resMes.split("|");// 拆分页面应答数据
			String Stat=str[14];//交易状态
			String CpSeqId=str[5];//交易流水号
			String transAmt=str[9];//金额 分为单位
			
			TransactionBean pay = new TransactionBean();
			pay.setResponseCode(Res_Code);
			pay.setPurpose(plainData);
			pay.setStat(Res_stat);
			pay.setData(resMes);
			pay.setChkValue(Res_chkValue);

			// 对收到的ChinaPay应答传回的域段进行验签
			boolean buildOK = false;
			boolean res = false;
			int KeyUsage = 0;
			PrivateKey key = new PrivateKey();
			try {
				buildOK = key.buildKey("999999999999999", KeyUsage,
						Config.PubKeyPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (!buildOK) {//获取私钥失败
				msg = "获取私钥失败";
				return false;
			}

			SecureLink sl = new SecureLink(key);
			res = sl.verifyAuthToken(Data, Res_chkValue);
			if (res) {//验证数据正确
				if (Stat.equals("s")||Stat.equals("5")) {// 交易成功
                    StringBuffer sBuffersBuffer=new StringBuffer();
                    sBuffersBuffer.append("交易成功");
                    msg=CpSeqId;
					return true;
				} else if (Stat.equals("6")) {
					String amount = transAmt;
					StringBuffer msssg =new StringBuffer();
					 msg=CpSeqId;
					msssg.append("银行已退单");
					return false;
				} else if (Stat.equals("9")) {
					String amount = transAmt;
					StringBuffer msssg =new StringBuffer();
					 msg=CpSeqId;
					msssg.append("重汇已退单");
					return false;
				} else {
					return false;
				}
			} else {//签名数据不匹配
				msg = "签名数据不匹配";
				return false;
			}
		}
     return false;
	}
}
