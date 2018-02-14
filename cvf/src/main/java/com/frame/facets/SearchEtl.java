package com.frame.facets;

import org.apache.lucene.store.Directory;
import org.apache.lucene.util.Version;

public interface SearchEtl {
	public static final String DirectoryPath = "D:\\temp\\text\\";
	public static final Version Lucene_Version = Version.LUCENE_4_10_4;
	/**
	 * 创建索引文件
	 */
	public <T> void startCreateDataIndex(T t);
	/**
	 * 删除索引
	 */
	public <T> void deleteIndex(T t);
	/**
	 * 更新索引
	 */
	public <T> void updateIndex(T t);
	/**
	 * 创建索引磁盘
	 * @return
	 * @throws Exception
	 */
	public Directory getDirectory() throws Exception;
}
