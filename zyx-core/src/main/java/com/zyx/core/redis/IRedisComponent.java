package com.zyx.core.redis;

/**
 * Created by MrDeng on 2016/7/28.
 */
public interface IRedisComponent {
    /**
     * 执行redis的SETNX命令
     * @param key
     * @param timeMillisecond
     * @return
     */
    public Boolean setIfAbsent(String key, Long timeMillisecond);

    /**
     * 执行redis的GET命令
     * @param key
     * @return
     */
    public Long get(String key);

    /**
     * 执行redis的GETSET命令
     * @param key
     * @param timeMillisecond
     * @return
     */
    public Long getAndSet(String key, Long timeMillisecond);

    /**
     * 执行redis的DEL命令
     * @param key
     * @return
     */
    public void delete(String key);
}
