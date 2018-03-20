package com.springframe;

import org.springframework.context.ApplicationEvent;
/**
 * 自定义事件
 * @author bobo
 *
 */
public class ApplicationEventManager extends ApplicationEvent{

	public ApplicationEventManager(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
		System.out.println("ApplicationEventManager ApplicationEventManager");
	}

}
