package com.zyx.core.lock;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by MrDeng on 2016/7/28.
 */
public class RedisLock implements Lock,Serializable {
    private IRedisLockArithmetic arithmetic;

    private String key;

    public RedisLock(String key, IRedisLockArithmetic arithmetic) {
        this.key = key;
        this.arithmetic = arithmetic;
    }
    @Override
    public void lock() {
        arithmetic.lock(key);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        arithmetic.unlock(key);
    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
