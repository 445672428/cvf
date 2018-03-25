package com.annotation.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.SourceLocation;

import com.annotation.SysLogColumn;

public class SysLogAspect {
    public void beforeAdvice(JoinPoint joinpoint) {
    	String f = joinpoint.getKind();
    	SourceLocation e = joinpoint.getSourceLocation();
    	StaticPart d = joinpoint.getStaticPart();
    	Object c = joinpoint.getTarget();
    	Object b =joinpoint.getThis();
    	String a = joinpoint.toLongString();
    	String methodName = joinpoint.getSignature().getName();
    	List<Object> args = Arrays.asList(joinpoint.getArgs());
    	try {
			getMthodRemark(joinpoint);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        System.out.println("前置通知执行了");
    }

    public void afterAdvice(JoinPoint joinpoint) {
        System.out.println("后置通知执行了");
    }

    public void afterReturnAdvice(JoinPoint joinPoint,Object result) {
        System.out.println("返回通知执行了" + "运行业务方法返回的结果为" + result);
    }

    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    	Object result = null;
        try {
            System.out.println("环绕通知开始执行了");
//            long start = System.currentTimeMillis();
//            result = (String) proceedingJoinPoint.proceed();
//            long end = System.currentTimeMillis();
//            System.out.println("环绕通知执行结束了");
//            System.out.println("执行业务方法共计：" + (end - start) + "毫秒。");
        } catch (Throwable e) {
        	e.printStackTrace();
        }
        return result;
    }

    public void throwingAdvice(JoinPoint joinPoint, Exception e) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("异常通知执行了.");
//        stringBuffer.append("方法:").append(joinPoint.getSignature().getName()).append("出现了异常.");
//        stringBuffer.append("异常信息为:").append(e.getMessage());
//        System.out.println(stringBuffer.toString());
    }
    
	// 获取方法的中文备注____用于记录用户的操作日志描述
	public String getMthodRemark(JoinPoint joinPoint) throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		System.out.println("====调用" + methodName + "方法-开始！");
		Object[] arguments = joinPoint.getArgs(); // 获得参数列表
		System.out.println("打印出方法调用时传入的参数，可以在这里通过添加参数的类型，进行一些简易逻辑处理和判断");
		if (arguments.length <= 0) {
			System.out.println("=== " + methodName + " 方法没有参数");
		} else {
			for (int i = 0; i < arguments.length; i++) {
				System.out.println("==== 参数   " + (i + 1) + " : "
						+ arguments[i]);
			}
		}
		Class targetClass = Class.forName(targetName);
		Method[] method = targetClass.getMethods();
		String methode = "";
		for (Method m : method) {
			if (m.getName().equals(methodName)) {
				Class[] tmpCs = m.getParameterTypes();
				if (tmpCs.length == arguments.length) {
					SysLogColumn methodCache = m.getAnnotation(SysLogColumn.class);
					if(null != methodCache){
						methode = methodCache.operationName();
					}
					break;
				}
			}
		}
		return methode;
	}
}
