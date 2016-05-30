package com.live.test;

import java.sql.Timestamp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zyx.common.enums.LiveLab;
import com.zyx.common.enums.LiveType;
import com.zyx.entity.live.LiveInfo;
import com.zyx.service.live.impl.LiveInfoServiceImpl;

public class LiveTest {

	private static final Log log = LogFactory.getLog(LiveTest.class);

	public static void main(String[] args) {
		try {
			System.out.println("-------------------------");
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
			System.out.println(context.getApplicationName());
			context.start();
			LiveInfoServiceImpl liveInfoServie=(LiveInfoServiceImpl) context.getBean("liveInfoService");
			System.out.println(liveInfoServie);
//			
			LiveInfo liveInfo = new LiveInfo();
			liveInfo.setPublic(true);
			liveInfo.setType(LiveType.TEXT.getType());
			liveInfo.setCreateTime(new Timestamp(System.currentTimeMillis()));
			liveInfo.setStart(new Timestamp(System.currentTimeMillis()));
			liveInfo.setStart(new Timestamp(System.currentTimeMillis()+1000*60*60*10));
			liveInfo.setLab(LiveLab.NBA.getTab());
			liveInfo.setTitle("敏敏吃饭");
			liveInfo.setVedioUrl("http");
			
			liveInfoServie.save(liveInfo);
			
//			liveInfoServie.get(1);
			
		} catch (Exception e) {
			log.error("== DubboProvider context start error:",e);
		}
		synchronized (LiveTest.class) {
			while (true) {
				try {
					LiveTest.class.wait();
				} catch (InterruptedException e) {
					log.error("== synchronized error:",e);
				}
			}
		}
	}
}
