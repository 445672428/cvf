package com.entities;

public class MyBean {
	private String id;
	private int age;
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	
	public MyBean(){}
	@Override
	public String toString() {
		return super.toString();
	}
}
