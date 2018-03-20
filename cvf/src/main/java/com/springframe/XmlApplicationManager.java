package com.springframe;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;

public class XmlApplicationManager extends XmlBeanFactory{

	public XmlApplicationManager(Resource resource) throws BeansException {
		super(resource);
		// TODO Auto-generated constructor stub
		System.out.println("XmlApplicationManager XmlApplicationManager");
	}

}
