package com.zyx.core.thread;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by MrDeng on 2016/7/26.
 */
public abstract  class Workor implements Runnable,Serializable {
    /**
     * 线程ID
     */
    private Long threadId;
    /**
     * 线程名称
     */
    private String threadName;
    /**
     * 线程组名称
     */
    private String groupName;
    @Override
    public void run() {
        work();
    }
    public abstract  void work();

    public Long getThreadId() {
        return threadId;
    }

    public String getThreadName() {
        return threadName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
