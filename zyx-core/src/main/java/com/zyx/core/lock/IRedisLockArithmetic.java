package com.zyx.core.lock;

import java.io.Serializable;

/**
 * Created by MrDeng on 2016/7/28.
 * Redis 分布式 锁
 */
public interface IRedisLockArithmetic extends Serializable{
    /**
     * 加锁
     * @param key
     * @return
     */
    public boolean lock(String key);

    /**
     * 解锁
     * @param key
     * @return
     */
    public boolean unlock(String key);
}
