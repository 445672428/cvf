package com.base;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.frame.service.ConfigService;

public class BaseAction {
	protected static final Logger logger = LoggerFactory.getLogger(BaseAction.class);
	@Autowired
	protected ConfigService configService;
	


	/**
	 * 将数组转为json数组
	 * @param list
	 * @param excludes
	 * @throws IOException
	 */
	public <T> void writeListToJson(List<T> list, String[] excludes) throws IOException {
	
	}
	/**
	 * 将对象转为json对象
	 * @param object
	 * @param excludes
	 * @throws IOException
	 */
	public void writeObjectToJson(Object object, String[] excludes)throws IOException {
		
	}
}
