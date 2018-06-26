package com.training.deserialize;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class ObjectToJSON {

	@Test
	public void test1(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "Zhangsan");
		map.put("nickname","xiaozhang");
		
		String jsonString = JSON.toJSONString(map);
		System.out.println(jsonString);//{"name":"Zhangsan","nickname":"xiaozhang"}
	}
	
	@Test
	public void test2(){
		Map<String, String> map = new HashMap<>();
	}
}
