package com.springframe;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
/**
 * web程序启动初始化
 * @author bobo
 *
 */
public class WebContextInit implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("cvf启动");
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();//获取spring容器
		//ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("cvf关闭");
	}

}
