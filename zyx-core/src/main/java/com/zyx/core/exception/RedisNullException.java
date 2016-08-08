package com.zyx.core.exception;

/**
 * Created by MrDeng on 2016/8/2.
 */
public class RedisNullException extends Exception {
    /**
     *
     *
     * @param msg
     */
    public RedisNullException(String msg) {
        super(msg);
    }

    /**
     *
     *
     * @param msg
     * @param cause
     */
    public RedisNullException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
