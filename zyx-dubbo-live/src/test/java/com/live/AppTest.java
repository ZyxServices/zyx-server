package com.live;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.zyx.entity.live.LiveInfo;
import com.zyx.service.live.impl.LiveInfoServiceImpl;
import com.zyx.vo.live.LiveInfoVo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
		try {
			System.out.println("-------------------------");
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"classpath:spring/spring-context.xml");
			LiveInfoServiceImpl liveInfoService = context.getBean("liveInfoService", LiveInfoServiceImpl.class);
			List<Integer> list =  new ArrayList<>();
			list.add(323);
			list.add(324);
			list.add(325);
			List<LiveInfo> lives = liveInfoService.selectByIds(list);
			System.out.println(JSON.toJSONString(lives));
//			LiveInfoVo vo = new LiveInfoVo();
//			vo.setLab(1);
//			List<Integer> userIds= new ArrayList<Integer>();
//			userIds.add(1);
//			vo.setUserIds(userIds);
//
//			int count = liveInfoService.countLive(vo);
//			System.out.println(JSON.toJSONString("count "+count));
//			vo.setCount(count);
//			vo.setPageNo(2);
//			vo.setPageSize(3);
//			System.out.println(JSON.toJSONString(vo));
//			System.out.println("获取记录范围"+vo.getStart()+"   "+vo.getEnd());
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("== DubboProvider context start error:",e);
		}

		synchronized (AppTest.class) {
			while (true) {
				try {
					AppTest.class.wait();
				} catch (InterruptedException e) {
					// log.error("== synchronized error:",e);
				}
			}
		}
		//
	}
}
