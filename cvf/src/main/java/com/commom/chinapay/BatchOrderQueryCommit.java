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

public class BatchOrderQueryCommit extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2142459781677506016L;

	public static boolean chinapayCommit(Map<String, String> parMap, String msg) throws Exception {

		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setParameter(
				HttpMethodParams.HTTP_CONTENT_CHARSET, "GBK");
		String url = Config.BatchOrderQuery_url;
		PostMethod postMethod = new PostMethod(url);
		// 填入各个表单域的值
		NameValuePair[] data = {
				new NameValuePair("merId", parMap.get("merId")),
				new NameValuePair("fromDate", parMap.get("fromDate")),
				new NameValuePair("toDate", parMap.get("toDate")),
				new NameValuePair("stat", parMap.get("stat")),
				new NameValuePair("version", parMap.get("version")),
				new NameValuePair("signFlag", parMap.get("signFlag")),
				new NameValuePair("chkValue", parMap.get("chkValue"))
				};
		   System.out.println("chkValue is wrong " + parMap.get("chkValue"));
		// 将表单的值放入postMethod中
		postMethod.setRequestBody(data);
		// 执行postMethod
		try {
			    httpClient.executeMethod(postMethod);
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 读取内容
		InputStream resInputStream = null;
		try {
			resInputStream = postMethod.getResponseBodyAsStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 对收到的ChinaPay应答传回的域段进行验签
		boolean buildOK = false;
		boolean res = false;
		int KeyUsage = 0;
		PrivateKey key = new PrivateKey();
		try {
			buildOK = key.buildKey("999999999999999", KeyUsage, Config.PubKeyPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!buildOK) {
			msg = "获取私钥失败";
			return false;
		}
		SecureLink sl = new SecureLink(key);

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				resInputStream));
		String tempBf = null;
		String temp = null;
		String Res_chkValue = null;
		String resMes = "";
		int flag = 0;
		tempBf = reader.readLine();
		String Res_Code = tempBf.substring(0, 3);

		// 逐行验签
		while (tempBf != null) {
			int dex = tempBf.lastIndexOf("|");
			temp = tempBf.substring(0, dex + 1);
			Res_chkValue = tempBf.substring(dex + 1);
			String Data = new String(Base64.encode(temp.getBytes()));
			  System.out.println("chkValue2 is wrong " + Res_chkValue);
			res = sl.verifyAuthToken(Data, Res_chkValue);
			resMes += temp;
			if (res) {//验证数据正确
					String	str[]=temp.split("\\|");
					if (!str[0].equals("000")) {
						msg = "查询出错";
						return false;
					}
										
					if (!str[1].equals("0")) {
						String Stat=str[8];//交易状态
						String CpSeqId=str[2];//交易流水号
						String usrName=str[4];//收款人姓名
						String transAmt=str[5];//金额 分为单位
						if (Stat.equals("6")||Stat.equals("9")) {
							String amount = transAmt;
							StringBuffer msssg =new StringBuffer();
							msg=CpSeqId;
							msssg.append("查询已退单");
							return true;
						}
					}
					return true;
					
			} else {
				flag++;
			}
			tempBf = reader.readLine();
		}
		if (flag == 0) {
			//System.out.println("验签数据正确!");
		} else {
			msg = "签名数据不匹配";
			return false;
		}
		return false;
	}
}
