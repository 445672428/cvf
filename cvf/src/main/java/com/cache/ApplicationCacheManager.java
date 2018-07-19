package com.cache;

import java.util.List;

import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.frame.service.SysService;
import com.sql.DB;
import com.utils.CacheUtils;

public class ApplicationCacheManager extends ContextLoaderListener{
	
	@Override  
    public void contextInitialized(ServletContextEvent event) {  
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(wac.getServletContext());
		initDB(context);
	}
	
	public void initDB(ApplicationContext context) {
		SysService sysService = (SysService)context.getBean("sysService");
		List<DB> list = sysService.queryAllDbs();
		for(DB db : list){
			CacheUtils.put(db.getDbname(), db);
		}
	}

}
