package com.training;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.training.entity.Student;
/**
 * 将String转化为JSON对象
 * @author Jiang, Chao
 *
 */
public class StringtoJSONobject {

	/**
	 * 一般的JSON字符串转为Java的Object
	 */
	@Test
	public void test1(){
		System.out.println("一般的JSON字符串");
		String jsonString = "{\"name\":\"Tom\", \"age\":23}";
		Object json = JSONObject.parse(jsonString);
		System.out.println(json);//{"name":"Tom","age":23}
	}
	
	
	
	/**
	 * 使用单引号的JSON字符串转为Java的Object
	 */
	@Test
	public void test2(){
		System.out.println("JSON字符串使用单引号");
		String jsonString = "{'name':'Tom', 'age':23}";
		Object json = JSONObject.parse(jsonString);
		System.out.println(json);//{"name":"Tom","age":23}
	}
	/**
	 * 属性名没有引号的JSON字符串转为Java的Object
	 */
	@Test
	public void test3(){
		System.out.println("JSON字符串属性名没有引号（注意：属性值是字符串时，不能没有引号）");
		String jsonString = "{name:'Tom', age:23}";
		Object json = JSONObject.parse(jsonString, Feature.AllowUnQuotedFieldNames);
		System.out.println(json);//{"name":"Tom","age":23}
	}
	/**
	 * 一般的JSON字符串转为Java的实体对象，一般称之为反序列化
	 */
	@Test
	public void test4(){
		String jsonString = "{\"id\":11, \"name\":\"Tom\", \"age\":23}";
		Student stu = JSONObject.parseObject(jsonString, Student.class);
		System.out.println(stu);//Student [id=11, name=Tom, age=23]
	}
	/**
	 * JSON字符串转为JSONObject，JSONObject比Java Object具有更多的操作
	 */
	@Test
	public void test5(){
		String jsonString = "{name:'Tom', age:23, \"class\":\"first\"}";
		System.out.println("如果直接解析的话，打印出来的JSON是乱序的");
		JSONObject json = JSONObject.parseObject(jsonString);
		System.out.println(json);//{"name":"Tom","class":"first","age":23}
		System.out.println("可以按书写顺序打印结果");
		//从源码看，有序的JSONObject使用的是LinkedHashMap,默认使用的HashMap,不在意JSON顺序的话,建议不要使用下面这种方式
		JSONObject orderjson = JSONObject.parseObject(jsonString, Feature.OrderedField);
		System.out.println(orderjson);//{"name":"Tom","age":23,"class":"first"}
	}
	/**
	 * JSON字符串转为JSONObject，获取属性值
	 */
	@Test
	public void test6(){
		String jsonString = "{name:'Tom', age:23, \"class\":\"first\"}";
		JSONObject json = JSONObject.parseObject(jsonString);
		String name = json.getString("name");//获取JSON中的字符串属性值
		System.out.println("name :" + name);//name :Tom
		int age = json.getIntValue("age");//获取JSON中的整数型属性值
		System.out.println("age :" + age);//age :23
	}
	/**
	 * JSON字符串转为JSONObject，获取JSON子对象
	 */
	@Test
	public void test7(){
		String jsonString = "{name:'Tom', age:23, 'course':{courseId:'11',courseName:'English'}}";
		JSONObject obj = JSONObject.parseObject(jsonString);
		JSONObject score = obj.getJSONObject("course");
		System.out.println("获取JSON中的子元素:"+score);//{"courseName":"English","courseId":"11"}
	}
	/**
	 * 不规范JSON字符串转为JSONObject
	 */
	@Test
	public void test8(){
		String jsonString = "{name:'Tom', , ,age:23}";
		JSONObject json = JSONObject.parseObject(jsonString,Feature.IgnoreNotMatch);
		System.out.println(json);//{"name":"Tom","age":23}
	}
	
}
