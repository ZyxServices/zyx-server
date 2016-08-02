package com.zyx.core.thread.workors;
import com.zyx.constants.live.LiveConstants;
import com.zyx.core.lock.RedisLock;
import com.zyx.core.thread.Workor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by MrDeng on 2016/7/26.
 */
public class BatchSaveBarrageWorkor extends Workor{
    private static final long serialVersionUID = 728737816012587458L;
    @Autowired
    private RedisTemplate<String, Long> sizeRedis;
    @Override
    public void work() {
        System.out.println("批处理弹幕存储…………END");
    }


}
