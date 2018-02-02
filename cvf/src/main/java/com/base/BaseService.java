package com.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * BaseService作为所有Service的基类，需要使用的话，需要先编写一个继承自此类的类
 *
 * @param <T> 实体类型
 */
public class BaseService{
	protected static final Logger logger = LoggerFactory.getLogger(BaseService.class);
//	private BaseDao<T> baseDao;
//	private Class<T> modelClass;
//
//	public BaseService() {
//		modelClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//	}
}
