package com.training.entity;

import java.util.List;

/**
 * JsonPath 示例
 * @author Jiang, Chao
 *
 */
public class Employee {
	private int id;
	private String name;
	private List<String> colleague;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getColleague() {
		return colleague;
	}
	public void setColleague(List<String> colleague) {
		this.colleague = colleague;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
}
