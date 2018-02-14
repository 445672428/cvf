package com.frame.multil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multil.datasource.DynamicDataSource;

@Service
public class SearchService {
	@Autowired
	private DynamicDataSource mutildataSource;

}
