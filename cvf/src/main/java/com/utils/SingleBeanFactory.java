package com.utils;

import org.springframework.web.context.ContextLoader;

public class SingleBeanFactory {
	public static Object getFactoryBean(String bean) {
		return ContextLoader.getCurrentWebApplicationContext().getBean(bean);
	}
}
