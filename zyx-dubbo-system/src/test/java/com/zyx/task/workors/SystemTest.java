package com.zyx.task.workors;

import com.alibaba.fastjson.JSON;
import com.zyx.entity.live.LiveInfo;
import com.zyx.rpc.system.impl.DevaFacadeImpl;
import com.zyx.service.live.impl.LiveInfoServiceImpl;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class SystemTest extends TestCase {

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public SystemTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(SystemTest.class);
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
			DevaFacadeImpl devaFacadeImpl = context.getBean("devaFacade", DevaFacadeImpl.class);
			List devas = devaFacadeImpl.getDevaByModel(1,6);
			System.out.println(JSON.toJSONString(devas));
			System.out.println(JSON.toJSONString(devas==null?0:devas.size()));
//			 devas = devaFacadeImpl.getDevaByModel(2);
//			System.out.println(JSON.toJSONString(devas==null?0:devas.size()));
//			 devas = devaFacadeImpl.getDevaByModel(3);
//			System.out.println(JSON.toJSONString(devas==null?0:devas.size()));
//			 devas = devaFacadeImpl.getDevaByModel(6);
//			System.out.println(JSON.toJSONString(devas==null?0:devas.size()));
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("== DubboProvider context start error:",e);
		}

		synchronized (SystemTest.class) {
			while (true) {
				try {
					SystemTest.class.wait();
				} catch (InterruptedException e) {
					// log.error("== synchronized error:",e);
				}
			}
		}
		//
	}
}
