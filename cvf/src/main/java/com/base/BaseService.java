package com.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
/**
 * BaseService作为所有Service的基类，需要使用的话，需要先编写一个继承自此类的类
 *
 * @param <T> 实体类型
 */
public class BaseService{
	protected static final Logger logger = LoggerFactory.getLogger(BaseService.class);
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
	
	/**
	 * json字符串转为Map
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Map<String, Object> jsonStringToMap(String json){
		return JSON.parseObject(json,Map.class);
	}
	
	/**
	 * Map转为jsonObject
	 * @param map
	 * @return
	 */
	protected JSONObject mapToJsonObject(Map<Object,Object> map){
		return (JSONObject)JSONObject.toJSON(map);
	}
	/**
	 * 对象转为Map对象
	 * @param object
	 * @return
	 */
	protected Map<String, Object> objectToMap(Object object){
        JSONObject jsonObject = (JSONObject) JSON.toJSON(object);
        Set<Entry<String,Object>> entrySet = jsonObject.entrySet();
        Map<String, Object> map=new HashMap<String,Object>();
        for (Entry<String, Object> entry : entrySet) {
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }
	/**
	 * jsonobject转为class对象
	 * @param object
	 * @param clz
	 * @return
	 */
	public <T> T exchangeJsonToObject(JSONObject object, Class<T> clz) {
		T bean = JSON.toJavaObject(object, clz);
		return bean;
	} 
}
