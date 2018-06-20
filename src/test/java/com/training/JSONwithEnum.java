package com.training;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.training.entity.Color;
import com.training.entity.Schedule;
import com.training.entity.Week;

/**
 * 枚举类型的JSON转换
 * @author Jiang, Chao
 *
 */
public class JSONwithEnum {

	@Test
	public void test1(){
		String str = "{'Color':1}";
		Color obj = JSON.parseObject(str, Color.class);
		System.out.println(obj);
	}
	
	@Test
	public void test2(){
		Color color = Color.RED;
		String jsonString = JSON.toJSONString(color);
		System.out.println(jsonString);//"RED"
	}
	
	@Test
	public void test3(){
		Color color = Color.RED;
		String jsonString = JSON.toJSONString(color, SerializerFeature.WriteEnumUsingToString);
		System.out.println(jsonString);//"red"
		List<String> l = new ArrayList<String>();
		l.add(jsonString);
		
		String ss = l.get(0);
		String s = "red";
		System.out.println(s);
		System.out.println(ss);
		
		
	}
	
	@Test
	public void test4(){
		Color color = Color.RED;
		String jsonString = JSON.toJSONString(color, SerializerFeature.WriteEnumUsingName);
		System.out.println(jsonString);//"RED"
		
		int features = JSON.DEFAULT_GENERATE_FEATURE & ~SerializerFeature.WriteEnumUsingName.mask;
	    String text = JSON.toJSONString(color, features);
	    System.out.println(text);
	}
	@Test
	public void test5(){
		Schedule schedule = new Schedule();
		schedule.setWeek(Week.SUN);
		
		String jsonString = JSON.toJSONString(schedule, SerializerFeature.WriteEnumUsingName);
		System.out.println(jsonString);
	}
}
