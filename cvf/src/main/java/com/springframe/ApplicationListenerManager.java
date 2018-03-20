package com.springframe;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
/**
 * 定义一个事件监听类
 * @author bobo
 *
 */
public class ApplicationListenerManager implements ApplicationListener<ApplicationEvent>{
	 //使用注解@Async支持 这样不仅可以支持通过调用，也支持异步调用，非常的灵活，
	@Async
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("ApplicationListenerManager onApplicationEvent");
	}

}
