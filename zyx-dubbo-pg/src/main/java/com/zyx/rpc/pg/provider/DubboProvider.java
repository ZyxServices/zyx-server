package com.zyx.rpc.pg.provider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by XiaoWei on 2016/6/7.
 */

public class DubboProvider {
    private static final Log log = LogFactory.getLog(DubboProvider.class);

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
//            System.out.println(context.getApplicationName());
            context.start();
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("== DubboProvider context start error:", e);
        }
    }
}
