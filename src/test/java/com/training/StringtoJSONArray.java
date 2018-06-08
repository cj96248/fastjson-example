package com.training;

import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;

/**
 * 将String转化为JSON数组
 * 
 * @author Jiang, Chao
 *
 */
public class StringtoJSONArray {

	/**
	 * 一般的JSON字符串转为Java的Object
	 */
	@Test
	public void test1() {
		String array = "[\"Tom\", \"Berry\", \"Jack\"]";
		Object obj = JSONArray.parse(array);
		System.out.println(obj);// ["Tom","Berry","Jack"]
	}

	/**
	 * 特殊格式的JSON字符串转为Java的Object
	 */
	@Test
	public void test2() {
		String array = "['Tom', ,'Alan', null, 2, 'Berry']";
		Object obj = JSONArray.parse(array);
		System.out.println(obj);// ["Tom","Alan",null,2,"Berry"]
	}

	/**
	 * JSON数组字符串转为Java的List
	 */
	@Test
	public void test3() {
		String array = "['Tom', 'Jack', 'Alan', null,'Berry']";
		List<String> list = JSONArray.parseArray(array, String.class);
		list.stream().forEach(System.out::println);// Tom Jack Alan null Berry
	}

	/**
	 * 一般的JSON字符串转为JSON Array
	 */
	@Test
	public void test4() {
		String array = "[\"Tom\", \"Berry\", \"Jack\"]";
		JSONArray ja = JSONArray.parseArray(array);
		System.out.println(ja);// ["Tom","Berry","Jack"]
		int size = ja.size();
		System.out.println("Array的长度：" + size);//Array的长度：3
		String name = ja.getString(1);
		System.out.println("Array中的数据：" + name);//Array中的数据：Berry
	}

}
