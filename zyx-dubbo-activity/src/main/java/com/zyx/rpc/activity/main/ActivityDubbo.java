package com.zyx.rpc.activity.main;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ActivityDubbo {

    private static final Log log = LogFactory.getLog(ActivityDubbo.class);

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
            context.start();
            System.in.read();
        } catch (Exception e) {
            log.error("== DubboProvider context start error:", e);
        }
    }

}