package org.service;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyx.entity.live.LiveInfo;
import com.zyx.service.live.LiveInfoService;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import tk.mybatis.mapper.entity.Example;

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
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
//		System.out.println(context.getApplicationName());
		context.start();
		
		LiveInfoService liveInfoServie = (LiveInfoService) context.getBean("liveInfoService");
		System.out.println(liveInfoServie);
		Example qe = new Example(LiveInfo.class);
		qe.createCriteria().andGreaterThan("lab", 1);
		List<LiveInfo> list = liveInfoServie.selectByExample(qe);
		
		System.out.println(list.size());
		
		LiveInfo liveInfo = new LiveInfo();
//		liveInfo.setType(1);
		
		List<LiveInfo> slist = liveInfoServie.select(liveInfo);
		System.out.println(slist);
		
		assertTrue(true);
	}
}
