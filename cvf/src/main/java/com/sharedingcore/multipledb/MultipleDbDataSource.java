package com.sharedingcore.multipledb;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultipleDbDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		return dataSourceKey.get();
	}
	public static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();
	
	public static void setDataSourceKey(String dataSource) {
		dataSourceKey.set(dataSource);
	}
	public static void removeDataSourceKey(String dataSource) {
		dataSourceKey.remove();
	}
}
