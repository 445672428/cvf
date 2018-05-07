package com.commom.chinapay;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import chinapay.Base64;
import chinapay.PrivateKey;
import chinapay.SecureLink;


public class GenerateSignature {
	public static Log log = LogFactory.getLog(GenerateSignature.class);
	
	public static String getChkValue(Map<String, String> parMap) throws UnsupportedEncodingException {
		//签名数据组装
		TransactionBean pay=new TransactionBean();
		pay.setMerId(parMap.get("merId"));
		pay.setMerDate(parMap.get("merDate"));
		pay.setMerSeqId(parMap.get("merSeqId"));
		pay.setCardNo(parMap.get("cardNo"));
		pay.setUserName(parMap.get("usrName"));
		pay.setOpenBank(parMap.get("openBank"));
		pay.setProv(parMap.get("prov"));
		pay.setCity(parMap.get("city"));
		pay.setTransAmt(parMap.get("transAmt"));
		pay.setPurpose(parMap.get("purpose"));
		pay.setSubBank(parMap.get("subBank"));
		pay.setFlag(parMap.get("flag"));
		pay.setVersion(parMap.get("version"));
		
		String merId =parMap.get("merId");
		String merDate =parMap.get("merDate");
		String merSeqId  =parMap.get("merSeqId");
		String cardNo  =parMap.get("cardNo");
		String usrName  =parMap.get("usrName");
		String openBank  =parMap.get("openBank");
		String prov  =parMap.get("prov");
		String city  =parMap.get("city");
		String transAmt  =parMap.get("transAmt");
		String purpose  =parMap.get("purpose");
		String subBank  =parMap.get("subBank");
		String flag   =parMap.get("flag");
		String version    =parMap.get("version");
		String termType  =parMap.get("termType");
		
		
		//签名
		String Data=merId + merDate + merSeqId + cardNo + usrName + openBank + prov + city + transAmt + purpose + subBank + flag + version + termType;
		log.info("生成的签名参数："+Data);
		//String Data = pay.toString();
		//String plainData = new String(Base64.encode(Data.getBytes()));//win环境
				String plainData = new String(Base64.encode(Data.getBytes("GBK")));//UNIX
		String chkValue = null;
		int KeyUsage = 0;
		PrivateKey key = new PrivateKey();
		log.info("Config.merId："+Config.merId);
		log.info("Config.MerKeyPath："+Config.MerKeyPath);
	    key.buildKey(Config.merId, KeyUsage, Config.MerKeyPath);
		SecureLink sl = new SecureLink(key);

		chkValue = sl.Sign(plainData);
		log.info("生成的签名："+chkValue);
	    return chkValue;
	}
	
	
	public static String getQueryChkValue(Map<String, String> parMap) throws UnsupportedEncodingException {
		//签名数据组装
		String merId = parMap.get("merId");
		String merDate = parMap.get("merDate");// 8
		String merSeqId = parMap.get("merSeqId");
		String version = parMap.get("version");
		
		//签名
		String Data = merId + merDate + merSeqId + version;
		//String plainData = new String(Base64.encode(Data.getBytes()));//win环境
				String plainData = new String(Base64.encode(Data.getBytes("GBK")));//UNIX
		String chkValue = null;
		int KeyUsage = 0;
		PrivateKey key = new PrivateKey();
	    key.buildKey(Config.merId, KeyUsage, Config.MerKeyPath);
		SecureLink sl = new SecureLink(key);

		chkValue = sl.Sign(plainData);
		TransactionBean query = new TransactionBean();
		query.setMerId(merId);
		query.setMerDate(merDate);
		query.setMerSeqId(merSeqId);
		query.setVersion(version);
		query.setChkValue(chkValue);
	    return chkValue;
	}
	
	
	public static String getBatchOrderQueryChkValue(Map<String, String> parMap) throws UnsupportedEncodingException {
		//签名数据组装
		String merId = parMap.get("merId");
		String fromDate = parMap.get("fromDate");// 8
		String toDate = parMap.get("toDate");
		String stat = parMap.get("stat");
		String version = parMap.get("version");
		
		//签名
		String Data =  merId + fromDate + toDate + stat + version;

		//String plainData = new String(Base64.encode(Data.getBytes()));//win环境
		String plainData = new String(Base64.encode(Data.getBytes("GBK")));//UNIX
		String chkValue = null;
		int KeyUsage = 0;
		PrivateKey key = new PrivateKey();
	    key.buildKey(Config.merId, KeyUsage, Config.MerKeyPath);
		SecureLink sl = new SecureLink(key);

		chkValue = sl.Sign(plainData);
		TransactionBean charge = new TransactionBean();
		charge.setMerId(merId);
		charge.setFromDate(fromDate);
		charge.setToDate(toDate);
		charge.setStat(stat);
		charge.setVersion(version);
		charge.setChkValue(chkValue);
	    return chkValue;
	}
	
}
