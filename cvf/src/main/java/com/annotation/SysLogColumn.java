package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.sql.Date;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SysLogColumn {
	/**
	 * 执行操作的方式
	 * @return
	 */
	public String operationType() default "";
	
	/**
	 * 要执行操作的具体行为
	 * @return
	 */
	public String operationName() default "";
	
	/**
	 * 操作参数
	 * @return
	 */
	public String[] operationArgs() default "";
	
	public Class<?> clz() default Date.class;
	
	public ElementType handlerType() default ElementType.TYPE;  
	
	public Target eee() default @Target(value = { ElementType.TYPE });
	
}
