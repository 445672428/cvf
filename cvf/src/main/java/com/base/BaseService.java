package com.base;

import java.util.List;

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
	
	protected String createOrCondition(List<String> list,String column){
		String condition = "";
		for (int i = 0; i < list.size(); i++) {
			if ( i == (list.size() - 1)) {
				condition += column + " = '" + list.get(i) +"'";
			}else{
				condition += column + " = '" + list.get(i) + "' or ";
			}
		}
		return condition;
	}
}
