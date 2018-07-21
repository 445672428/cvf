package com.annotation.aspect;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.socket.ListenEvent;
import com.utils.TimeUtils;

public class AccessLogAspect {
	protected static final Logger logger = LoggerFactory.getLogger(AccessLogAspect.class);
	/**
	 * 前置通知
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	public void beforeAdvice(JoinPoint joinpoint) {
		try {
			getMthodRemark(joinpoint,null,"前置通知",null);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		logger.info("前置通知执行了");
	}
	
	// 获取方法的中文备注____用于记录用户的操作日志描述
	public void getMthodRemark(JoinPoint joinPoint, Exception e,String msg,Object obj)throws Exception {
		String methodName = joinPoint.getSignature().getName();
		String time = TimeUtils.getCurrentDateStringAll();
		msg = time+"------------>调用:" + methodName + "方法!";
		Object[] arguments = joinPoint.getArgs(); // 获得参数列表
		msg += "详情:";
		if (arguments.length <= 0) {
			msg += methodName + " 方法没有参数,";
		} else {
			for (int i = 0; i < arguments.length; i++) {
				if (null == arguments[i]) {
					continue;
				}
				msg += "第"+ (i + 1) +"参数:   " + arguments[i].toString()+"。";
			}
		}
		if (null!=obj) {
			msg += "返回值:"+obj.toString();
		}
		ListenEvent.add(msg);		
	}
}
