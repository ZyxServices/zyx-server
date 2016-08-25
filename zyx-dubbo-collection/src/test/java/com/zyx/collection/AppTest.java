package com.zyx.collection;

import com.alibaba.fastjson.JSON;
import com.zyx.param.collection.CollectionParam;
import com.zyx.service.collection.impl.CollectionServiceImpl;
import com.zyx.vo.collection.CollectionVo;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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
			CollectionServiceImpl collectionService = context.getBean("collectionService", CollectionServiceImpl.class);

			CollectionParam param = new CollectionParam();
			param.setUserId(1);
			param.setModel(2);
			List<CollectionVo> list = collectionService.selectCollections(param);
			System.out.println(JSON.toJSONString(list));
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
