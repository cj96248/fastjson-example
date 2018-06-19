package com.training;

import java.lang.reflect.Type;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.training.entity.America;
import com.training.entity.Country;
/**
 * 带泛型的Jave bean转换
 * @author Jiang, Chao
 *
 */
public class JSONwithGeneric {

	/**
	 * 泛型对象不能简单转换
	 */
	@Test
	public void test1(){
		String str = "{'code':11, 'name':'America', 'state':{'capital':'Washington', 'language':'English'}}";
		Object obj = JSON.parseObject(str, Country.class);
		System.out.println(obj);
		//Country [code=11, name=America, state={"capital":"Washington","language":"English"}]
		Country<America> country = JSON.parseObject(str, Country.class);
		System.out.println(country);
		//Country [code=11, name=America, state={"capital":"Washington","language":"English"}]
	}
	/**
	 * 泛型对象需要先声明Type
	 */
	@Test
	public void test2(){
		String str = "{'code':11, 'name':'America', 'state':{'capital':'Washington', 'language':'English'}}";
		Type type = new TypeReference<Country<America>>(){}.getType();
		Object obj = JSON.parseObject(str, type);
		System.out.println(obj);
		//Country [code=11, name=America, state=America [capital=Washington, language=English]]
	}
}
