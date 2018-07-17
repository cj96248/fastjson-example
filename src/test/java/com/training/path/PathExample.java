package com.training.path;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.alibaba.fastjson.JSONPath;
import com.training.entity.Employee;

public class PathExample {
	
	static Employee employee = new Employee();
	
	static Employee empty = new Employee();
	
	@BeforeClass
	public static void init() {
		employee.setId(1);
		employee.setName("小明");
		
		List<String> list = Arrays.asList("张三","李四","王五","赵六");
		employee.setColleague(list);
	}

	/**
	 * eval:求值
	 */
	@Test
	public void test1() {
		Object name = JSONPath.eval(employee, "$.name");
		System.out.println(name); //小明
		
		Object ename = JSONPath.eval(employee, "$['id']");
		System.out.println(ename); //1

	}
	/**
	 * 计算Size，Map非空元素个数，对象非空元素个数，数组的长度。其他无法求值返回-1
	 */
	@Test
	public void test2() {
		int colleagues = JSONPath.size(employee, "$.colleague");
		System.out.println(colleagues); //4
		
		int size = JSONPath.size(employee, "$");
		System.out.println(size); //3
		
		int none = JSONPath.size(employee, "$.name");
		System.out.println(none); //-1
	}
	/**
	 * path中是否存在/包含对象
	 */
	@Test
	public void test3() {
		boolean hasName = JSONPath.contains(employee, "$.name");
		System.out.println(hasName); //true
		
		boolean obj = JSONPath.contains(empty, "$");
		System.out.println(obj); //true
		
		boolean none = JSONPath.contains(employee, "$.name");
		System.out.println(none); //-1
	}
	/**
	 * path中是否存在/包含某值
	 */
	@Test
	public void test4() {
		boolean hasName = JSONPath.containsValue(employee, "$.name","小明");
		System.out.println(hasName); //true
		
		boolean obj = JSONPath.containsValue(empty, "$","");
		System.out.println(obj); //false
		
		boolean none = JSONPath.containsValue(employee, "$.id","11");
		System.out.println(none); //false
	}
}
