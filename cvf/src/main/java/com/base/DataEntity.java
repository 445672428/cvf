package com.base;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.utils.Reflections;

/**
 * 最基础的实体属性
 * 
 * @author bobo
 *
 */
public class DataEntity<T> implements CreateTree,Serializable{
	private static String getMethodName(String fildeName) throws Exception{
		  byte[] items = fildeName.getBytes();
		  items[0] = (byte) ((char) items[0] - 'a' + 'A');
		  return new String(items);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4604114498803040960L;
	private T t;
	private String id;
	private String pid;
	private boolean leaf;
	private String text;
	
	private String[] fiters = {"id:code","pid:parentcode","text:name"};
	
	@SuppressWarnings("rawtypes")
	protected Class clazz;
	private static  enum SORTTYPE { DESC, ASC };
	
	private List<CreateTree> list = new ArrayList<CreateTree>();
	
	public void setList(List<CreateTree> list) {
		this.list = list;
	}
	public List<CreateTree> getList() {
		return list;
	}
	public DataEntity(){
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		// 获得父类上的泛型数组
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		t =  (T) actualTypeArguments[0];
		clazz = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}
	
	@Override
	public CreateTree getCreate() {
//		getObjectVal();

		return (CreateTree)t;
	}

	@Override
	public List<CreateTree> getCreates() {
		return this.getList();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public void getObjectVal(){
		Class<? super T> superClz= clazz.getSuperclass();//获取父类
		Field[] superFields = superClz.getDeclaredFields();//获取父类的属性
		Field[] dfields = clazz.getDeclaredFields();
		//这里将子类的值赋值给父类
		for (int i = 0; i < dfields.length; i++) {
			Field field = dfields[i];
			String name = field.getName();
			field.setAccessible(true);
			try {
				Class<?> type = field.getType();
				String simpleName = type.getSimpleName();
				Object value = null;

				System.out.println(value);
			} catch (Exception e) {
 				e.printStackTrace();
			}
		}
	}
	

	public String[] getFiters() {
		return fiters;
	}
	public void setFiters(String[] fiters) {
		this.fiters = fiters;
	}  
}
