package com.springframe;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/**
 * web程序启动初始化
 * @author bobo
 *
 */
public class WebContextInit implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("cvf启动");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("cvf关闭");
	}

}
