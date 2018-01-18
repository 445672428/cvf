package com.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.annotation.Column;

/**
 * 反射处理
 * @author bobo
 *
 */
public class ReflectUtil {
	public static <T> T reflectToEntity(Class<T> clazz,Map<String, Object> map){
		Field[] fields = clazz.getDeclaredFields();
		Map<String, String> fieldHasColumnAnnoMap = new LinkedHashMap<String, String>();
		Annotation[] annotations = null;
		for(Field field :fields){
			annotations = field.getAnnotations();
			for(Annotation annotation : annotations){
				Column column = (Column)annotation;
				fieldHasColumnAnnoMap.put(field.getName(), column.name());
			}
		}
		 //存放field name 和 对应的来自map的该field的属性值，用于后续reflect成ModelBean  
        Map<String, Object> conCurrent = new LinkedHashMap<String, Object>();  
        for (Map.Entry<String, String> en : fieldHasColumnAnnoMap.entrySet())  
        {  
            //将column大写。因为jdbcMapResult key is UpperCase  
            String key = en.getValue().toUpperCase();  
              
            //获得map的该field的属性值  
            Object value = map.get(key);  
              
            //确保value有效性，防止JSON reflect时异常  
            if (value != null)  
            {  
                conCurrent.put(en.getKey(), map.get(key));  
            }  
        }  
        return JSON.parseObject(JSON.toJSONString(conCurrent), clazz);
	}
}
