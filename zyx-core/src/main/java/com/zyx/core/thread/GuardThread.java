package com.zyx.core.thread;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
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
    public GuardThread() {
    }

    @PostConstruct
    public void start() {
//        System.out.println("****************启动守护进程***************");
        new Thread(new Runnable() {
            @Override
            public void run() {
                int sleepTime = 500;
//                System.out.println("****************运行守护进程***************");
                while (true) {
                    try {
                        Workor workor = redisTemplate.opsForList().rightPop("tq");
//                        System.out.println("***************守护进程 扫描中 任务：***************" + workor);
                        if (workor != null) {
//                            System.out.println("***************Do workor 立即再次扫描**************" + workor.getThreadName());
                            globalThreadPool.submitWorkor(workor);
                            sleepTime = 0;
                        } else {
//                            System.out.println("***************No workor 修改守护扫描时间间隔为1s**************");
                            //测试
//                            Random r = new Random(System.currentTimeMillis());
//                            int n = r.nextInt() % 5 + 1;
//                            for (int i = 0; i < n; i++) {
//                                BatchSaveBarrageWorkor tw = new BatchSaveBarrageWorkor();
//                                tw.setThreadName("test:" + r.nextInt());
//                                redisTemplate.opsForList().leftPush(Constants.REDIS_THREADH_QUEUE, tw);
//                            }
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
