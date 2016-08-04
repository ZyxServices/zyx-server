package com.zyx.core.workors;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MrDeng on 2016/7/26.
 */
public abstract  class Workor implements Runnable,Serializable {
    private static final long serialVersionUID = -5832717692258803068L;
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

    private Map<String,Object> params;
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

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        if(params==null)
            params=new HashMap<>();
        this.params = params;
    }
}
