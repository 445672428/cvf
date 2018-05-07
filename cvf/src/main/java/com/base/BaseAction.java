package com.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.entities.China;
import com.frame.service.ConfigService;
import com.mybatis.pojo.INNODB_CMP_RESET;

public class BaseAction {
	protected static final Logger logger = LoggerFactory.getLogger(BaseAction.class);
	@Autowired
	protected ConfigService configService;
	@Test
	public void nannn(){
		China china = new China("波波", "123", "2");
		china.getCreate();
		System.out.println(china);
	}
	
	/**
	 * @param list
	 * @param clz
	 * @return
	 */
	public <T> List<T> exchangeJsonToList(List<Map<String, Object>> list,Class<T> clz) {
		JSONArray array = JSONArray.parseArray(JSON.toJSONString(list));
		return exchangeJsonToList(array,clz);
	}
	/**
	 * 
	 * @param array
	 * @param clz
	 * @return
	 */
	public <T> List<T> exchangeJsonToList(JSONArray array, Class<T> clz) {
		return array.toJavaList(clz);
	}
	/**
	 * 
	 * @param object
	 * @param clz
	 * @return
	 */
	public <T> T exchangeJsonToObject(JSONObject object, Class<T> clz) {
		T bean = JSON.toJavaObject(object, clz);
		return bean;
	}
	/**
	 * 将对象转为Map
	 * @param object
	 * @return
	 */
	public Map<String, Object> objectToMap(Object object){
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
