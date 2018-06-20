package com.training.entity;
/**
 * 带有值的枚举类型：选择颜色
 * @author Jiang, Chao
 *
 */
public enum Color {

	RED("red"),
	BLUE("blue"),
	GREEN("green"),
	YELLOW("yellow");
	
	String value;
	
	Color(String value){
		this.value = value;
	}
	
	public String value(){
		return value;
	}
	
	public String toString(){
		return value;
	}
	
	
}
