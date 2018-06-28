package com.annotation.aspect;

import java.lang.reflect.Method;

import javax.websocket.Session;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.annotation.SysLogColumn;
import com.socket.ListenEvent;
import com.socket.TomcatLogSocket;
import com.utils.SysDateFormat;

public class SysLogAspect {

	protected static final Logger logger = LoggerFactory.getLogger(SysLogAspect.class);
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
	/**
	 * 后置通知
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	public void afterAdvice(JoinPoint joinpoint) {
		try {
			getMthodRemark(joinpoint, null,"后置通知",null);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	/**
	 * 后置返回值通知
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	public void afterReturnAdvice(JoinPoint joinPoint, Object result) {
		try {
			getMthodRemark(joinPoint, null,"后置返回值通知",result);
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	/**
	 * 环绕通知
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint)
			throws Throwable {
		Object result = null;
		try {
			getMthodRemark(proceedingJoinPoint, null,"环绕通知",null);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 异常通知
	 * @param proceedingJoinPoint
	 * @return
	 * @throws Throwable
	 */
	public void throwingAdvice(JoinPoint joinPoint, Exception e) {
		try {
			getMthodRemark(joinPoint, null,"异常通知",null);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	// 获取方法的中文备注____用于记录用户的操作日志描述
	public String getMthodRemark(JoinPoint joinPoint, Exception e,String msg,Object obj)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		String time = SysDateFormat.getCurrentDateStringAll();
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
		Class targetClass = Class.forName(targetName);
		Method[] method = targetClass.getMethods();
		String methode = "";
		for (Method m : method) {
			if (m.getName().equals(methodName)) {
				Class[] tmpCs = m.getParameterTypes();
				if (tmpCs.length == arguments.length) {
					SysLogColumn methodCache = m.getAnnotation(SysLogColumn.class);
					if (null != methodCache) {
						methode = methodCache.operationName();
						msg += methode+"!";
					}
					break;
				}
			}
		}
		return methode;
	}
}
