package com.training.entity;
/**
 * 含有枚举类型
 * @author Jiang, Chao
 *
 */
public class Schedule {

	private int code;
	private String name;
	private Week week;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Week getWeek() {
		return week;
	}
	public void setWeek(Week week) {
		this.week = week;
	}
	@Override
	public String toString() {
		return "Schedule [code=" + code + ", name=" + name + ", week=" + week + "]";
	}
	
}
