package com.base;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 最基础的实体属性
 * 
 * @author bobo
 *
 */
public class DataEntity<T> implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -4604114498803040960L;
	
	private String id;
	private String pid;
	private boolean leaf;
	private String text;
	private boolean open = false;
	
	private T t;
	private Map<String, String> filter = new HashMap<String, String>();
	private List<DataEntity<T>> children;
	
	private List<DataEntity<T>> datas;

	private void setChildren(List<DataEntity<T>> children) {
		this.children = children;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}


	public DataEntity() {
		// ParameterizedType genericSuperclass = (ParameterizedType)
		// this.getClass().getGenericSuperclass();
		// // 获得父类上的泛型数组
		// Type[] actualTypeArguments =
		// genericSuperclass.getActualTypeArguments();
		// t = (T) actualTypeArguments[0];
		// System.out.println("t"+t.toString());
		// clazz = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
		// System.out.println("clazz"+clazz.toString());
	}

	@Override
	public String toString() {
		return "DataEntity [id=" + id + ", pid=" + pid + ", leaf=" + leaf
				+ ", text=" + text + ", open=" + open + ", children="
				+ children + "]";
	}

	
	private void setId(String id) {
		this.id = id;
	}

	private String getId() {
		return id;
	}

	private void setPid(String pid) {
		this.pid = pid;
	}
	
	private String getPid() {
		return pid;
	}

	private void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	private String getText() {
		return text;
	}

	private void setText(String text) {
		this.text = text;
	}

	private DataEntity<T> reflectBeanToTreeValue(T t) {
		DataEntity<T> dataEntity = new DataEntity<T>();
		Field[] dfields = t.getClass().getDeclaredFields();
		// 这里将子类的值赋值给父类
		for (int i = 0; i < dfields.length; i++) {
			Field field = dfields[i];
			String name = field.getName();
			field.setAccessible(true);
			Class<?> type = field.getType();
			String simpleName = type.getSimpleName();// 获取泛型类型

			String value = getFieldValue(t, name, simpleName).toString();
			String beanId = filter.get("id");
			String beanPid = filter.get("pid");
			String beanText = filter.get("text");
			if (name.equals(beanId)) {
				dataEntity.setId(value);
			} else if (name.equals(beanPid)) {
				dataEntity.setPid(value);
			} else if (name.equals(beanText)) {
				dataEntity.setText(value);
			}

		}
		return dataEntity;
	}

	private Object getFieldValue(Object owner, String fieldName,String simpleName) {
		Object o = invokeMethod(owner, fieldName, null, simpleName);
		if (null==o) {
			return "";
		}
		return invokeMethod(owner, fieldName, null, simpleName).toString();
	}

	private Object invokeMethod(Object owner, String fieldName, Object[] args,String simpleName) {
		Class<? extends Object> ownerClass = owner.getClass();

		// fieldName -> FieldName
		String methodName = fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);

		Method method = null;
		try {
			method = ownerClass.getMethod("get" + methodName);
		} catch (SecurityException e) {
			return null;
		} catch (NoSuchMethodException e) {
			return null;
		}
		try {
			Object o = method.invoke(owner);
			// 判断当前类型

			return o;
		} catch (Exception e) {
			return null;
		}
	}


	public DataEntity<T> getCreates(List<DataEntity<T>> nodes,DataEntity<T> pNode) {
		DataEntity<T> node = new DataEntity<T>();
		node.setId(pNode.getId());
		if (node.getId() != null) {
			node.setOpen(true);
		}
		node.setText(pNode.getText());
		node.setLeaf(false);
		node.setChildren(new ArrayList<DataEntity<T>>());
		if (nodes == null) {
			return node;
		}
		if (hasChild(nodes, node)) {
			List<DataEntity<T>> lt = new ArrayList<DataEntity<T>>();
			List<DataEntity<T>> childList = getChildList(nodes, node);
			Iterator<DataEntity<T>> it = childList.iterator();
			while (it.hasNext()) {
				DataEntity<T> modules = (DataEntity<T>) it.next();
				// 递归
				lt.add(getCreates(nodes, modules));
			}
			node.setChildren(lt);
		} else {
			node.setLeaf(true);
		}
		return node;
	}

	/**
	 * 判断是否有子节点
	 */
	private boolean hasChild(List<DataEntity<T>> list, DataEntity<T> node) {
		return getChildList(list, node).size() > 0 ? true : false;
	}

	/**
	 * 得到子节点列
	 */
	private List<DataEntity<T>> getChildList(List<DataEntity<T>> list,DataEntity<T> modules) {
		List<DataEntity<T>> li = new ArrayList<DataEntity<T>>();
		Iterator<DataEntity<T>> it = list.iterator();
		while (it.hasNext()) {
			DataEntity<T> temp = (DataEntity<T>) it.next();
			if (temp.getPid().equals(modules.getId())) {
				li.add(temp);
			}
		}
		return li;
	}

	public DataEntity<T> getDatas() {
		DataEntity<T> dataEntity = reflectBeanToTreeValue(this.t);
		dataEntity = getCreates(this.datas,dataEntity);
		return dataEntity;
	}

	public void setDatas(List<T> datas,T pNode,Map<String, String> filter) {
		this.filter = filter;
		this.t = pNode;
		List<DataEntity<T>> list = new ArrayList<DataEntity<T>>();
		for(T t :datas){
			DataEntity<T> d = reflectBeanToTreeValue(t);
			list.add(d);
		}
		this.datas = list;
	}



}
