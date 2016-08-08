package com.zyx.core.exception;

/**
 * Created by MrDeng on 2016/7/28.
 */
public class RedisLockCreateException extends RedisLockException  {

    private static final String baseMsg = "RedisLock创建异常: %s";
    public RedisLockCreateException(String msg) {
        super(baseMsg);
    }

    public RedisLockCreateException(String msg, Throwable cause) {
        super(baseMsg, cause);
    }
}
