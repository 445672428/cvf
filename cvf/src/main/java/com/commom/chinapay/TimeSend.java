package com.commom.chinapay;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TimeSend  {
	public static Log log = LogFactory.getLog(TimeSend.class);
	



	public void timerTaskServers() throws Exception {
		//querySend();//单笔交易查询
		//BatchOrderQuery();//退单查询
	}

	
	public void querySend() throws Exception {
		try {
			// 最近一个月处理中的订单
			List<Map<String, Object>> list = null;//appService.getmerchantWithdrawLog(" UNIX_TIMESTAMP(add_time)> date_sub(curdate(),interval 30 day) and state =2 ");
			if (list != null) {
				for (Map<String, Object> map : list) {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Map<String, String> proMap = new HashMap<String, String>();
					
					proMap.put("merId", Config.merId);
					if (map.get("trading_date") != null) {
						proMap.put("merDate",
								String.valueOf(map.get("trading_date")));
					}
					if (map.get("order_no") != null) {
						proMap.put("merSeqId",
								String.valueOf(map.get("order_no")));
					}
					proMap.put("version", "20090501");
					String chkValue = GenerateSignature
							.getQueryChkValue(proMap);// 签名
					proMap.put("chkValue", chkValue);
					proMap.put("signFlag", "1");
					String msg = "";
					QuerySendCommit.chinapayCommit(proMap,
							String.valueOf(map.get("merchant_id")), msg);
					log.info("单笔查询交易：" + msg);
				}
			}

		} catch (Exception e) {
			log.info("单笔查询交易：" + e);
		}
	}

	
	public void BatchOrderQuery() throws Exception {
		try {
			// 最近3天处理中的订单
			Map<String, String> proMap = new HashMap<String, String>();
			proMap.put("merId", Config.merId);
			Calendar  calendar=  Calendar.getInstance();
			calendar.roll(Calendar.DAY_OF_YEAR, -2);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			String FromDate = formatter.format(calendar.getTime());
			proMap.put("fromDate", FromDate);
			Date date = new Date();
			String toDate = formatter.format(date);
			proMap.put("toDate", toDate);
			proMap.put("stat", "6,9");
			proMap.put("version", "20090501");
			String chkValue = GenerateSignature
					.getBatchOrderQueryChkValue(proMap);// 签名
			proMap.put("chkValue", chkValue);
			proMap.put("signFlag", "1");

			String msg = "";
			BatchOrderQueryCommit.chinapayCommit(proMap, msg);
			log.info("批量退单查询：" + msg);

		} catch (Exception e) {
			log.info("批量退单查询：" + e);
		}
	}
}
