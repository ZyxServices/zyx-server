package com.zyx.core.exception;

/**
 * Created by MrDeng on 2016/7/28.
 */
public class RedisLockException extends RuntimeException  {

    /**
     * 创建RedisLockException
     * @param msg
     */
    public RedisLockException(String msg) {
        super(msg);
    }

    /**
     * 创建RedisLockException
     * @param msg
     * @param cause
     */
    public RedisLockException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
