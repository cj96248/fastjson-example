package com.training.entity;

public class Country<T> {

	private String code;
	private String name;
	private T state;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public T getState() {
		return state;
	}
	public void setState(T state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + ", state=" + state + "]";
	}
	
}
