package com.live;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.zyx.common.enums.LiveLab;
import com.zyx.common.enums.LiveType;
import com.zyx.entity.live.LiveInfo;
import com.zyx.entity.live.TextLiveItem;
import com.zyx.rpc.live.LiveInfoFacade;
import com.zyx.rpc.live.TextLiveItemFacade;
import com.zyx.service.live.TextLiveItemService;
import com.zyx.service.live.impl.LiveInfoServiceImpl;
import com.zyx.vo.common.TimeAreaVo;
import com.zyx.vo.live.LiveInfoVo;
import com.zyx.vo.live.TextLiveItemVo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

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
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
			// System.out.println(context.getApplicationName());
			context.start();
//			 LiveInfoServiceImpl liveInfoServie = (LiveInfoServiceImpl)
//			 context.getBean("liveInfoService");
////			 LiveInfo sliveInfo = liveInfoServie.selectByKey(37L);
//			 System.out.println(sliveInfo.getCreateTime());

//			 LiveInfoVo liveInfoVo = new LiveInfoVo();
//			 liveInfoVo.setDistinct(true);
//			 liveInfoVo.setOredCriteria("create_time");
//			 List<LiveInfo> list = liveInfoServie.selectByExample(liveInfoVo);

			// System.out.println(list);
			// System.out.println(liveInfoServie);
			//
			// long now = System.currentTimeMillis();
			// System.out.println(new SimpleDateFormat("yyyy-MM-dd
			// HH:mm:ss:SSS").format(now));
			// LiveInfo liveInfo = new LiveInfo();
			// liveInfo.setPublic(true);
			// liveInfo.setType(LiveType.TEXT.getType());
			// liveInfo.setCreateTime(now);
			// liveInfo.setStart(now);
			// liveInfo.setStart(now);
			//
			// liveInfo.setLab(LiveLab.NBA.getTab());
			// liveInfo.setTitle("······");
			//
			////
			// liveInfoServie.save(liveInfo);

			// List<LiveInfo> list = liveInfoServie.select(liveInfo);
			// System.out.println(list);
			// System.out.println(liveInfoServie.selectCount(liveInfo));
			// System.out.println("*******************");
			// TextLiveItemService textLiveItemService =
			// (TextLiveItemServiceImpl) context.getBean("textLiveItemService");

			// Example qe = new Example(LiveInfo.class);
			// Criteria criterira = qe.createCriteria();
			// criterira.andEqualTo("lab", 1);
			// List<LiveInfo> list = liveInfoServie.selectByExample(qe);
			// System.out.println(list);
			//
			// for(LiveInfo info :list){
			// System.out.println(info.getCreateTime());
			// System.out.println(new SimpleDateFormat("yyyy-MM-dd
			// HH:mm:ss:SSS").format(info.getCreateTime()));
			// }

//			TextLiveItemFacade textLiveItemFacade = (TextLiveItemFacade) context.getBean("textLiveItemFacade");
//
//			TextLiveItemVo textLiveItemVo = new TextLiveItemVo();
//
//			textLiveItemVo.setLiveId(1L);
//			List<TextLiveItem> textList = textLiveItemFacade.getList(textLiveItemVo);
//			
//			System.out.println(textList);

			 LiveInfoFacade liveInfoFacade = (LiveInfoFacade)context.getBean("liveInfoFacade");
//			 LiveInfoVo liveInfoVo = new LiveInfoVo();
//			 TimeAreaVo createTime = new TimeAreaVo();
//			 createTime.setStart(1465890700790L);
//			 createTime.setEnd(14658990700790L);
//			liveInfoVo.setCreateTime(createTime);
//			List<LiveInfo> list = liveInfoFacade.getList(liveInfoVo );
//			System.out.println(com.alibaba.fastjson.JSON.toJSONString(list));
			LiveInfo liveInfo = liveInfoFacade.getById(41L);
			System.out.println(JSON.toJSONString(liveInfo));
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
