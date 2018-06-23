package com.training.serialize;

import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

/**
 * 将String转化为JSON
 * 
 * @author Jiang, Chao
 *
 */
public class StringtoJSON {

	/**
	 * 一般的JSON字符串转为Java的Object
	 */
	@Test
	public void test1() {
		String str = "{\"Jack\":{'age':23,grade:'8'}, \"Berry\":{age:25,grade:'9'}}";
		Object obj = JSONObject.parse(str);
		System.out.println("乱序输出：" + obj);
		//乱序输出：{"Berry":{"grade":"9","age":25},"Jack":{"grade":"8","age":23}}
		obj = JSONObject.parse(str, Feature.OrderedField);
		System.out.println("顺序输出："+ obj); 
		//顺序输出：{"Jack":{"age":23,"grade":"8"},"Berry":{"age":25,"grade":"9"}}
	}

	/**
	 * 特殊格式的JSON字符串转为Java的Object
	 */
	@Test
	public void test2() {
		String array = "{['Tom', ,'Alan', null, 2, 'Berry']}";
		Object obj = JSONArray.parse(array);
		System.out.println(obj);// ["Tom","Alan",null,2,"Berry"]
	}

	/**
	 * JSON数组字符串转为Java的List
	 */
	@Test
	public void test3() {
		String array = "{['Tom', 'Jack', 'Alan', null,'Berry']}";
		List<String> list = JSONArray.parseArray(array, String.class);
		list.stream().forEach(System.out::println);// Tom Jack Alan null Berry
	}

	/**
	 * 一般的JSON字符串转为JSON Array
	 */
	@Test
	public void test4() {
		String array = "{[\"Tom\", \"Berry\", \"Jack\"]}";
		JSONArray ja = JSONArray.parseArray(array);
		System.out.println(ja);// ["Tom","Berry","Jack"]
		int size = ja.size();
		System.out.println("Array的长度：" + size);//Array的长度：3
		String name = ja.getString(1);
		System.out.println("Array中的数据：" + name);//Array中的数据：Berry
	}

}
