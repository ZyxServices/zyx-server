package com.live;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.zyx.vo.common.TimeAreaVo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class LiveTest extends TestCase {

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public LiveTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(LiveTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
		

		
		TimeAreaVo timeArea = JSON.parseObject("{start:1,start:2}", TimeAreaVo.class);
		
		System.out.println(timeArea.getStart());
		
		List<Integer> list = JSON.parseArray("[1,2,3]", Integer.class);
		for(Integer i :list){
			System.out.println(i);
		}
		
	}
}
