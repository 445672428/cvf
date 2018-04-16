package com.utils.excel;

import java.util.Map;


public interface PoiExtractContent<T> {
	/**
	 * 根据文件获取Document路径
	 * @param docPath
	 * @return
	 */
	public T getDocuemnt(String docPath);
	/**
	 * 获取文档标题
	 * @param doc
	 * @return
	 */
	public String getTitle(T doc);

	/**
	 * 获取文档所有文字内容
	 * @param docPath
	 * @return
	 */
	public String getContent(String docPath);
	/**
	 * 获取文档所有图片另存路径
	 * @param doc
	 * @param picPath
	 * @param suffix
	 */
	public void getPictures(T doc,String picPath,String suffix);
	
	/**
	 * 获取文档所有表格
	 * @param doc
	 */
	public void getTable(T doc);
	
	/**
	 * 获取文档最大字体
	 * @param doc
	 * @return
	 */
	public int getMaxFontSize(T doc);
	
	public Map<String, String> getInfoDoc(T doc);
}
