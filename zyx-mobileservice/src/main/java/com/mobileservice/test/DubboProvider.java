package com.mobileservice.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboProvider {
	
	private static final Log log = LogFactory.getLog(DubboProvider.class);

	public static void main(String[] args) {
		try {
			System.out.println("-------------------------");
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
			System.out.println(context.getApplicationName());
			context.start();
			System.in.read();
		} catch (Exception e) {
			log.error("== DubboProvider context start error:",e);
		}
//		synchronized (DubboProvider.class) {
//			while (true) {
//				try {
//					DubboProvider.class.wait();
//				} catch (InterruptedException e) {
//					log.error("== synchronized error:",e);
//				}
//			}
//		}
	}
    
}