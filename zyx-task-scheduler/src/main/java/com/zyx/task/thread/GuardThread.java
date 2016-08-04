package com.zyx.task.thread;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.zyx.core.workors.Workor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.PostConstruct;

/**
 * Created by MrDeng on 2016/8/1.
 * 线程池守护线程
 */
public class GuardThread {
    private static final Logger logger = LoggerFactory.getLogger(GuardThread.class);
    @Autowired
    RedisTemplate<String, Workor> redisTemplate;
    @Autowired
    GlobalTreadPool globalThreadPool;
    @PostConstruct
    public void start() {
//        logger.info("****************启动守护进程***************");
        new Thread(new Runnable() {
            @Override
            public void run() {
                int sleepTime = 500;
//                logger.info("****************运行守护进程***************");
                while (true) {
                    try {
                        Workor workor = redisTemplate.opsForList().rightPop("tq");
//                        logger.info("***************守护进程 扫描中 任务：***************" + workor);
                        if (workor != null && globalThreadPool != null) {
                            globalThreadPool.submitWorkor(workor);
                            sleepTime = 0;
                        } else {
                            sleepTime = 500;
                        }
                        if (sleepTime > 0)
                            Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
