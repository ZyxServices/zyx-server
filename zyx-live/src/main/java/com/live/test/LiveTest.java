package com.live.test;

import java.sql.Timestamp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.common.enums.LiveLab;
import com.common.enums.LiveType;
import com.entity.live.LiveInfo;
import com.service.live.impl.LiveInfoServiceImpl;

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
			
			LiveInfo liveInfo = new LiveInfo();
			liveInfo.setType(LiveType.TEXT.getType());
			liveInfo.setStart(new Timestamp(System.currentTimeMillis()));
			liveInfo.setStart(new Timestamp(System.currentTimeMillis()+1000*60*60*10));
			liveInfo.setLab(LiveLab.NBA.getTab());
			liveInfo.setTitle("敏敏吃饭");
			
			liveInfoServie.save(liveInfo);
			
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
