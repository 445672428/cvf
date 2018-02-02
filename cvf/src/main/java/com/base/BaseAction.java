package com.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.frame.service.ConfigService;

public class BaseAction {
	protected static final Logger logger = LoggerFactory.getLogger(BaseAction.class);
	@Autowired
	protected ConfigService configService;
}
