package com.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMakerUtils {
	private static FreeMakerUtils freeMakerUtils = null;
	private static Configuration configuration = null;
	private FreeMakerUtils(){}
	
	public static FreeMakerUtils getInstance(String name){
		if(freeMakerUtils==null){
			configuration = new Configuration();
			configuration.setClassForTemplateLoading(FreeMakerUtils.class, name);
			configuration.setDefaultEncoding("UTF-8");
			freeMakerUtils = new FreeMakerUtils();
		}
		return freeMakerUtils;
	}
	
	public Template getTemplate(String name) {
		Template tmp = null;
		Configuration cfg = new Configuration();
		// 指定模板路径
		File file = new File("");
		try {
			cfg.setDirectoryForTemplateLoading(file);
			tmp = cfg.getTemplate(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return tmp;
	}

	public void fprintFreeMakerTemp(String name, Map<String, Object> rootMap,
			String outFile) {
		FileWriter out = null;
		try {
			out = new FileWriter(new File(outFile));
			Template tmp = this.getTemplate(name);
			tmp.process(rootMap, out);
		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		} finally {
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
