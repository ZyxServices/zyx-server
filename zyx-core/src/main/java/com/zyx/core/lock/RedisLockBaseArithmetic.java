package com.zyx.core.lock;

import com.zyx.core.redis.IRedisComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by MrDeng on 2016/7/28.
 */
public class RedisLockBaseArithmetic implements IRedisLockArithmetic {

    private Logger logger = LoggerFactory.getLogger(RedisLockBaseArithmetic.class);
    /**
     * redis操作方法
     */
    private IRedisComponent redisComp;

    /**
     * 超时时间，以毫秒为单位<br />
     * 默认为5分钟
     */
    private long overtime = 5 * 60 * 1000L;

    /**
     * 休眠时长，以毫秒为单位<br />
     * 默认为100毫秒
     */
    private long sleeptime = 100L;

    /**
     * 当前时间
     */
    private long currentLockTime;

    public IRedisComponent getRedisComp() {
        return redisComp;
    }

    public long getOvertime() {
        return overtime;
    }

    public long getSleeptime() {
        return sleeptime;
    }

    public long getCurrentLockTime() {
        return currentLockTime;
    }

    public void setRedisComp(IRedisComponent redisComp) {
        this.redisComp = redisComp;
    }

    public void setOvertime(long overtime) {
        this.overtime = overtime;
    }

    public void setSleeptime(long sleeptime) {
        this.sleeptime = sleeptime;
    }

    public void setCurrentLockTime(long currentLockTime) {
        this.currentLockTime = currentLockTime;
    }

    @Override
    public boolean lock(String key) {
        while(true) {
            // 当前加锁时间
            currentLockTime = System.currentTimeMillis();

            if(redisComp.setIfAbsent(key, currentLockTime)) {
                // 获取锁成功
                logger.debug("直接获取锁{key: {}, currentLockTime: {}}", key, currentLockTime);
                return true;
            } else {
                //其他线程占用了锁
                logger.debug("检测到锁被占用{key: {}, currentLockTime: {}}", key, currentLockTime);
                Long otherLockTime = redisComp.get(key);
                if(otherLockTime == null) {
                    // 其他系统释放了锁
                    // 立刻重新尝试加锁
                    logger.debug("检测到锁被释放{key: {}, currentLockTime: {}}", key, currentLockTime);
                    continue;
                } else {
                    if(currentLockTime - otherLockTime >= overtime) {
                        //锁超时
                        //尝试更新锁
                        logger.debug("检测到锁超时{key: {}, currentLockTime: {}, otherLockTime: {}}", key, currentLockTime, otherLockTime);
                        Long otherLockTime2 = redisComp.getAndSet(key, currentLockTime);
                        if(otherLockTime2 == null || otherLockTime.equals(otherLockTime2)) {
                            logger.debug("获取到超时锁{key: {}, currentLockTime: {}, otherLockTime: {}, otherLockTime2: {}}", key, currentLockTime, otherLockTime, otherLockTime2);
                            return true;
                        } else {
                            sleep();
                            //重新尝试加锁
                            logger.debug("重新尝试加锁{key: {}, currentLockTime: {}}", key, currentLockTime);
                            continue;
                        }
                    } else {
                        //锁未超时
                        sleep();
                        //重新尝试加锁
                        logger.debug("重新尝试加锁{key: {}, currentLockTime: {}}", key, currentLockTime);
                        continue;
                    }
                }
            }
        }
    }

    @Override
    public boolean unlock(String key) {
//        logger.debug("解锁{key: {}}", key);
        redisComp.delete(key);
        return true;
    }

    /**
     * 休眠<br />
//     * @param sleeptime
     */
    private void sleep() {
        try {
            Thread.sleep(sleeptime);
        } catch (InterruptedException e) {
//            throw new Exception("线程异常中断", e);
        }
    }
}
