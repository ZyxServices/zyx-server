package com.live;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyx.common.enums.LiveLab;
import com.zyx.common.enums.LiveType;
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
//			System.out.println(context.getApplicationName());
			context.start();
			LiveInfoServiceImpl liveInfoServie = (LiveInfoServiceImpl) context.getBean("liveInfoService");
			LiveInfoVo liveInfoVo = new LiveInfoVo();
			liveInfoVo.setDistinct(true);
//			liveInfoVo.setOredCriteria("create_time");
			List<LiveInfo> list = liveInfoServie.selectByExample(liveInfoVo);
			
			System.out.println(list);
			System.out.println(liveInfoServie);
			//
			LiveInfo liveInfo = new LiveInfo();
			liveInfo.setPublic(true);
			liveInfo.setType(LiveType.TEXT.getType());
			liveInfo.setCreateTime(new Timestamp(System.currentTimeMillis()));
			liveInfo.setStart(new Timestamp(System.currentTimeMillis()));
			liveInfo.setStart(new Timestamp(System.currentTimeMillis() + 1000 * 60 * 60 * 10));
			liveInfo.setLab(LiveLab.NBA.getTab());
			liveInfo.setTitle("······");
			liveInfo.setVedioUrl("http");

			liveInfoServie.save(liveInfo);
//			System.out.println("*******************");
//			TextLiveItemService textLiveItemService = (TextLiveItemServiceImpl) context.getBean("textLiveItemService");
//			
//			TextLiveItem textLiveItem = new TextLiveItem();
//			textLiveItem.setLvieId(1);
//			textLiveItem.setCreateTime(new Timestamp(System.currentTimeMillis()));
//			textLiveItem.setContent("textLiveItem");
//			textLiveItem.setImgUrl("URL");
//			long n =textLiveItemService.add(textLiveItem);
//			System.out.println("**********insert :"+n);

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
