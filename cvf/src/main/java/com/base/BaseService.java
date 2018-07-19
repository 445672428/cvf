package com.base;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * BaseService作为所有Service的基类，需要使用的话，需要先编写一个继承自此类的类
 *
 * @param <T> 实体类型
 */
public class BaseService{
	protected static final ObjectMapper objectMapper = new ObjectMapper();
	
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


	public <T> List<Map<String, Object>> arrayObjectToList(List<T> t) {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		for(Object o : t){
			list.add(objectToMap(o));
		}
		return list;
	}
	
	/**
	 * 将对象转为json字符串
	 * @param obj
	 * @param excludes 过滤不需要转换的字段
	 * @param clz
	 * @return
	 */
	public <T> String writeObjectToJson(Object obj, String[] excludes, Class<T> clz) {
		// 属性过滤器对象
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(clz,excludes);
		// 属性排斥集合,强调某些属性不需要或者一定不能被序列化
		Set<String> fileds = filter.getExcludes();
		// 属性包含集合,强调仅需要序列化某些属性.具体用哪一个,看实际情况.此处我用的前者
		// Set<String> includes = filter.getIncludes();
		// 排除不需序列化的属性
		for (String string : excludes) {
			fileds.add(string);
		}
		String str = JSON.toJSONString(obj, filter,SerializerFeature.DisableCircularReferenceDetect);
		return str;
	}
	
	/**
	 * 将对象转为json对象
	 * @param object
	 * @param excludes
	 * @throws IOException
	 */
	public String writeObjectToJson(Object object, String[] excludes)throws IOException {
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(excludes);
		String str = JSON.toJSONString(object, filter,SerializerFeature.DisableCircularReferenceDetect);
		return str;
	}
}
