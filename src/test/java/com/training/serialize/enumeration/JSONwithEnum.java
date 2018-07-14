package com.training.serialize.enumeration;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.training.entity.enumeration.Color;
import com.training.entity.enumeration.Schedule;
import com.training.entity.enumeration.Week;

/**
 * 枚举类型的JSON转换
 * @author Jiang, Chao
 *
 */
public class JSONwithEnum {

	@Test
	public void test1(){
		Color color = Color.RED;
		String jsonString = JSON.toJSONString(color);
		System.out.println(jsonString);//"RED"
	}
	@Test
	public void test2(){
		Color color = Color.RED;
		String jsonString = JSON.toJSONString(color, SerializerFeature.WriteEnumUsingName);
		System.out.println(jsonString);//"RED"
	}
	@Test
	public void test3(){
		Color color = Color.RED;
		String jsonStr = JSON.toJSONString(color, SerializerFeature.WriteEnumUsingToString);
		System.out.println(jsonStr);//"red" -> 这里的String是带有引号的
		System.out.println(jsonStr.equals("red"));//false
		System.out.println(jsonStr.length());//5
	}
	
	@Test
	public void test4(){
		Color color = Color.YELLOW;
		int features = JSON.DEFAULT_GENERATE_FEATURE & ~SerializerFeature.WriteEnumUsingName.mask;
	    String text = JSON.toJSONString(color, features);
	    System.out.println(text);// 3  -> 这里输出的是枚举的ordinal
	}
	@Test
	public void test5(){
		Schedule schedule = new Schedule();
		schedule.setWeek(Week.SUN);
		
		String jsonString = JSON.toJSONString(schedule);
		System.out.println(jsonString); //{"code":0,"week":"SUN"}
	}
	
	@Test
	public void test6(){
		Schedule schedule = new Schedule();
		schedule.setWeek(Week.MON);
		
		String jsonString = JSON.toJSONString(schedule, SerializerFeature.WriteEnumUsingName);
		System.out.println(jsonString); //{"code":0,"week":"MON"}
	}
}
