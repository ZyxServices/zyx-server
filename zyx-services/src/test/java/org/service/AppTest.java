package org.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyx.service.live.impl.LiveInfoServiceImpl;

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
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
//		System.out.println(context.getApplicationName());
		context.start();
		LiveInfoServiceImpl liveInfoServie = (LiveInfoServiceImpl) context.getBean("liveInfoService");
		System.out.println(liveInfoServie);
		assertTrue(true);
	}
}
