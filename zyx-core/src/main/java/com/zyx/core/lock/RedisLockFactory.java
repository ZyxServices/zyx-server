package com.zyx.core.lock;

import com.zyx.core.exception.RedisLockCreateException;
import com.zyx.core.redis.IRedisComponent;
import org.apache.commons.lang3.StringUtils;
/**
 * Created by MrDeng on 2016/7/28.
 */
public class RedisLockFactory {
    /**
     * 操作redis的
     */
    private IRedisComponent redisComponent;

    /**
     * 超时时间
     */
    private String overtime;

    /**
     * 休眠时间
     */
    private String sleeptime;

    public void setRedisComponent(IRedisComponent redisComponent) {
        this.redisComponent = redisComponent;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }

    public void setSleeptime(String sleeptime) {
        this.sleeptime = sleeptime;
    }

    public IRedisComponent getRedisComponent() {
        return redisComponent;
    }

    public String getOvertime() {
        return overtime;
    }

    public String getSleeptime() {
        return sleeptime;
    }

    public RedisLock createLock(String key) {
        RedisLockBaseArithmetic arithmetic = new RedisLockBaseArithmetic();
        if(redisComponent != null) {
            arithmetic.setRedisComp(redisComponent);
        } else {
            throw new RedisLockCreateException("redisComponent未初始化");
        }
        if(StringUtils.isNotEmpty(overtime)) {
            arithmetic.setOvertime(Long.parseLong(overtime));
        }
        if(StringUtils.isNotEmpty(sleeptime)) {
            arithmetic.setSleeptime(Long.parseLong(sleeptime));
        }
        RedisLock lock = new RedisLock(key, arithmetic);
        return lock;
    }
}
