package com.zyx.core.thread;

import com.zyx.core.thread.Workor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by MrDeng on 2016/7/26.
 */
public class GlobalTreadPool {
    private ThreadPoolExecutor executor;
    int corePoolSize = 10;
    int maximumPoolSizeize = 20;
    long keepAliveTime = 200;
    int workQueueSize = 50;

    public GlobalTreadPool() {
        this.executor = new ThreadPoolExecutor(this.corePoolSize, this.maximumPoolSizeize, this.keepAliveTime, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(this.workQueueSize));
    }
    public void submitWorkor(Workor workor) {
        executor.execute(workor);
    }

}
