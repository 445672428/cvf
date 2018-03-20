package com.springframe;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
/**
 * 事件推送者
 * @author bobo
 *
 */
public class ApplicationPulisherManager implements ApplicationEventPublisher{

	public void publishEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		System.out.println("ApplicationPulisherManager publishEvent");
	}

}
