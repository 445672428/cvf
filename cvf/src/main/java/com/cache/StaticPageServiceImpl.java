package com.cache;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class StaticPageServiceImpl implements ServletContextAware{
	//SpringMvc 管理 conf
    private Configuration conf;
    public void setFreeMarkerConfig(FreeMarkerConfig freeMarkerConfig) {
        this.conf = freeMarkerConfig.getConfiguration();
    }
    //获取webapp下的html文件夹所在的位置
    //将相对路径转换为绝对路径
    public String getPath(String path){
        return servletContext.getRealPath(path);
    }
    //静态化页面的方法
    public void index(Map<String, Object> root, String id){
        //输出目录: 通过getPath方法获取的是绝对路径
        String path = getPath("/html/product/" + id +".html");
        File f = new File(path);
        File parentFile = f.getParentFile();
        if(!parentFile.exists()){
            parentFile.mkdirs();
        }
        
        //spring中已经设置了模板路径:<property name="templateLoaderPath" value="/WEB-INF/ftl/" />
        Writer out = null;
        
        try {
            //读
            Template template = conf.getTemplate("product.html");
            
            //设置输出的位置
            //写
            out = new OutputStreamWriter(new FileOutputStream(f), "UTF-8");
            template.process(root, out);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            if (out != null)
            {
                try {
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
        }
        
    }
    private ServletContext servletContext;
	@Override
	public void setServletContext(ServletContext servletContext) {
		 this.servletContext = servletContext;
	}

}
