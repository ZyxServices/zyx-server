package com.zyx.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @title BasicTest.java
 * @package com.zyx.mapper
 * @description TODO
 * @author ZhangHuaRong   
 * @update 2016年5月26日 下午2:57:37
 * @version V1.0  
 * Copyright (c)2012 chantsoft-版权所有
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BasicTest {
	@Test
	 public void test1(){
		 System.out.println("----------------------test-------------------");
	 }
}
