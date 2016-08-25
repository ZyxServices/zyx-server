package com.zyx.core.workors;

import com.zyx.core.exception.RedisNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Created by MrDeng on 2016/8/2.
 */
public class WorkorHelper {
    @Autowired
    RedisTemplate<String,Workor> redisTemplate;
    /**
     * 提交任务到任务队列
     */
    public void submitWorkor( Workor workor) throws RedisNullException {
        if(redisTemplate==null||redisTemplate.opsForList()==null){
            throw  new RedisNullException("redis cache queue connect failure");
        }else{
            System.out.println("提交任务");
            redisTemplate.opsForList().leftPush("tq", workor);
            System.out.println("提交任务后任务条数："+redisTemplate.opsForList().size("tq"));
        }
    }

}
