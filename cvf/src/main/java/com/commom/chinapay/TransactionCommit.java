package com.commom.chinapay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.corba.se.spi.orbutil.fsm.State;

import chinapay.Base64;
import chinapay.PrivateKey;
import chinapay.SecureLink;

/*
 * 银联代付提交类
 */
public class TransactionCommit extends HttpServlet {
	public static Log log = LogFactory.getLog(TransactionCommit.class);
	
	public static String chinapayCommit(Map<String, String> parMap,
			String merchantId) throws Exception {
		String msg = "交易成功";
		//AppService appService = new AppService();

		HttpClient httpClient = new HttpClient();
		httpClient.getParams().setParameter(
				HttpMethodParams.HTTP_CONTENT_CHARSET, "GBK");
		String url = Config.pay_url;
		PostMethod postMethod = new PostMethod(url);

		// 填入各个表单域的值
		NameValuePair[] data = {
				new NameValuePair("merId", parMap.get("merId")),
				new NameValuePair("merDate", parMap.get("merDate")),
				new NameValuePair("merSeqId", parMap.get("merSeqId")),
				new NameValuePair("cardNo", parMap.get("cardNo")),
				new NameValuePair("usrName", parMap.get("usrName")),
				new NameValuePair("openBank", parMap.get("openBank")),
				new NameValuePair("prov", parMap.get("prov")),
				new NameValuePair("city", parMap.get("city")),
				new NameValuePair("transAmt", parMap.get("transAmt")),
				new NameValuePair("purpose", parMap.get("purpose")),
				new NameValuePair("subBank", parMap.get("subBank")),
				new NameValuePair("flag", parMap.get("flag")),
				new NameValuePair("version", parMap.get("version")),
				new NameValuePair("termType", parMap.get("termType")),
				new NameValuePair("chkValue", parMap.get("chkValue")),
				new NameValuePair("signFlag", parMap.get("signFlag")) };

		log.info("data="+data);
		//data=null;
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
		log.info("接收银联参数："+resMes);
		int dex = resMes.lastIndexOf("&");
    
		// 拆分页面应答数据
		String str[] = resMes.split("&");
        
		log.info("str的长度："+str.length);
		log.info("resMes："+resMes);
		// 提取返回数据
		if (str.length == 10) {
			log.info("进了交易正常应答");
			int Res_Code = str[0].indexOf("=");
			int Res_merId = str[1].indexOf("=");
			int Res_merDate = str[2].indexOf("=");
			int Res_merSeqId = str[3].indexOf("=");
			int Res_cpDate = str[4].indexOf("=");
			int Res_cpSeqId = str[5].indexOf("=");
			int Res_transAmt = str[6].indexOf("=");
			int Res_stat = str[7].indexOf("=");
			int Res_cardNo = str[8].indexOf("=");
			int Res_chkValue = str[9].indexOf("=");

			String responseCode = str[0].substring(Res_Code + 1);
			String MerId = str[1].substring(Res_merId + 1);
			String MerDate = str[2].substring(Res_merDate + 1);
			String MerSeqId = str[3].substring(Res_merSeqId + 1);
			String CpDate = str[4].substring(Res_cpDate + 1);
			String CpSeqId = str[5].substring(Res_cpSeqId + 1);
			String TransAmt = str[6].substring(Res_transAmt + 1);
			String Stat = str[7].substring(Res_stat + 1);
			String CardNo = str[8].substring(Res_cardNo + 1);
			String ChkValue = str[9].substring(Res_chkValue + 1);

			String ressString = resMes.substring(0, dex);
			String plainData = new String(Base64.encode(ressString.getBytes()));

			// 传入显示页面的数据准备
			TransactionBean pay = new TransactionBean();
			pay.setResponseCode(responseCode);
			pay.setMerId(MerId);
			pay.setMerDate(MerDate);
			pay.setMerSeqId(MerSeqId);
			pay.setCpDate(CpDate);
			pay.setCpSeqId(CpSeqId);
			pay.setTransAmt(TransAmt);
			pay.setStat(Stat);
			pay.setCardNo(CardNo);
			pay.setData(resMes);

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
			if (!buildOK) {
				msg = "获取私钥失败";
				return false+"|"+msg;
			}

			SecureLink sl = new SecureLink(key);
			res = sl.verifyAuthToken(plainData, ChkValue);
			if (res) {// 验证数据正确

				if (responseCode.equals("0000")) {// 接收成功 商户判定交易状态stat
					// a）若stat为明确的成功/失败结果，商户记录订单结果，并进行后续处理。
					// b）stat没有返回明确的成功/失败结果，表示代付处理中，后续需要通过查询订单状态；
					// c）部分银行无法返回明确的回盘结果，可通过批量退单查询/控台查询等方式获取结果
					if (Stat.equals("s")) {// 交易成功
						return true+"|"+msg;
					} else if (Stat.equals("6")) {
						msg = "银行已退单";
						return false+"|"+msg;
					} else if (Stat.equals("9")) {
						msg = "重汇已退单";
						return false+"|"+msg;
					} else {
						return true+"|"+msg;
					}
					
				} else if (responseCode.equals("0100")|| responseCode.equals("0101")|| responseCode.equals("0102")|| responseCode.equals("0103")|| responseCode.equals("0104")) {// 接收失败
					if(responseCode.equals("0100")){
						msg = "商户提交的字段长度、格式错误";
					}
					else if(responseCode.equals("0101")){
						msg = "商户验签错误";
					}
					else if(responseCode.equals("0102")){
						msg = "手续费计算出错";
					}
					else if(responseCode.equals("0103")){
						msg = "商户备付金帐户金额不足";
					}
					else if(responseCode.equals("0104")){
						msg = "操作拒绝";
					}
					else{
						msg = "接收失败";
					}
					return false+"|"+msg;
				} else {
					msg = "重复交易";
					return false+"|"+msg;
				}
			} else {
				msg = "签名数据不匹配";
				return false+"|"+msg;
			}
		}

		// 交易失败应答
		if (str.length == 2) {
			log.info("进了交易失败应答");
			int Res_Code = str[0].indexOf("=");
			int Res_chkValue = str[1].indexOf("=");
			
			String responseCode = str[0].substring(Res_Code + 1);
			String ChkValue = str[1].substring(Res_chkValue + 1);

			String plainData = str[0];
			String plainData1 = new String(Base64.encode(plainData.getBytes()));

			TransactionBean pay = new TransactionBean();
			pay.setResponseCode(responseCode);
			pay.setData(resMes);
			
			
			if (responseCode.equals("0100")|| responseCode.equals("0101")|| responseCode.equals("0102")|| responseCode.equals("0103")|| responseCode.equals("0104")) {// 接收失败
				if(responseCode.equals("0100")){
					msg = "商户提交的字段长度、格式错误";
				}
				else if(responseCode.equals("0101")){
					msg = "商户验签错误";
				}
				else if(responseCode.equals("0102")){
					msg = "手续费计算出错";
				}
				else if(responseCode.equals("0103")){
					msg = "商户备付金帐户金额不足";
				}
				else if(responseCode.equals("0104")){
					msg = "操作拒绝";
				}
				else{
					msg = "接收失败";
				}
			} else {
				msg = "重复交易";
			}
			

			// 对收到的ChinaPay应答传回的域段进行验签
			boolean buildOK = false;
			boolean res = false;
			int KeyUsage = 0;
			PrivateKey key = new PrivateKey();
			try {
				buildOK = key.buildKey(Config.merId, KeyUsage,
						Config.MerKeyPath);

			} catch (Exception e) {
				e.printStackTrace();
			}
			if (!buildOK) {
//				msg = "获取私钥失败";
				return false+"|"+msg;
			}

			SecureLink sl = new SecureLink(key);
			res = sl.verifyAuthToken(plainData1, ChkValue);
			if (res) {// 更新订单表为提交失败并退钱
//				msg = responseCode;
				return false+"|"+msg;

			} else {
//				msg = "签名数据不匹配";
				return false+"|"+msg;
			}
		}

		return false+"|"+msg;
	}
	
	
	
	//银联查询是否到账提交
	public static int chinapayQuery(Map<String, String> parMap) throws Exception {
		int status=-1;
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

		log.info("data="+data.toString());
		//data=null;
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
		log.info("接收银联参数："+resMes);
    
		// 拆分页面应答数据
		String str[] = resMes.split("\\|");
        
		log.info("str的长度："+str.length);
		// 提取返回数据
		String returnCode = str[0]+"";
		String state = str[14]+"";
		if("000".equals(returnCode))
		{
			if("s".equals(state)){
				status=1;
			}else if("6".equals(state)){
				status=2;
			}
		}else{
			status=-1;
		}
		return status;
	}
}
