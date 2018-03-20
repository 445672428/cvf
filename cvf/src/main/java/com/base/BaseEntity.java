package com.base;

import java.io.Serializable;
import java.util.List;

import com.entities.Page;

public class BaseEntity<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5618159236949916110L;
	public BaseEntity() {}
	
	/**
	 * 当前实体分页对象
	 */
	protected Page<T> page;
	
	public Page<T> getPage() {
		if (page == null){
			page = new Page<T>();
		}
		return page;
	}
	
	public Page<T> setPage(Page<T> page) {
		this.page = page;
		return page;
	}
	
	/*
	 * JAVA所有集合类型
	 * */
	private static String[] SETTYPE = {"List","Map","Set","Collection",
										"String","Byte","Boolean","Short","Character",
										"Integer","Long","Float","Double","byte","boolean",
										"short","char","int","long","float","double"};
	
	/**
	 * 进行数据对象序列化
	 */
	protected List<T> serializableToObect(Object ...args) {
		
		return null;
	}
}
