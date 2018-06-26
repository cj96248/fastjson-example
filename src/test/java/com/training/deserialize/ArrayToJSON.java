package com.training.deserialize;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class ArrayToJSON {

	@Test
	public void test1(){
		List<String> list = new ArrayList<String>();
		list.add("ATM");
		
		String jsonString = JSON.toJSONString(list);
		System.out.println(jsonString);//["ATM"]
		
		list.add("RMB");
		
		String js = JSON.toJSONString(list);
		System.out.println(js);//["ATM","RMB"]
	}
}
