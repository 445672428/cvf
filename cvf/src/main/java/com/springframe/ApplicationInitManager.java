package com.springframe;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
/**
 * 应用配置
 * @author bobo
 *
 */
public class ApplicationInitManager implements ApplicationContextInitializer<ConfigurableApplicationContext>{

	public void initialize(ConfigurableApplicationContext applicationContext) {
		// TODO Auto-generated method stub
		System.out.println("ApplicationInitManager initialize");
	}

}
