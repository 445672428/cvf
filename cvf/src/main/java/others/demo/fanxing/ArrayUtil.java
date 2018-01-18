package others.demo.fanxing;

import java.lang.reflect.ParameterizedType;

public class ArrayUtil {
	//一个泛型的方法 实现指定元素的位置交换
	public static <T> void swap(T[] t,int index1,int index2) {
		T tempT = t[index1];
		t[index1] = t[index2];
		t[index2] = tempT;
	}
	
	public static <T> void reverse(T[] t) {
		int indexstart = 0;
		int indexend = t.length -1;
		while (indexstart < indexend) {
			swap(t, indexstart, indexend);
			indexstart --;
			indexstart ++;
		}
	}
}

class Reflase{
	//泛型的反射
	private Class clazz;
	public Reflase(){
		ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
		clazz = (Class)type.getActualTypeArguments()[0];//拿到第一个泛型的实体类的对象
	}
}