package com.zyx.core.workors;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.zyx.entity.live.Barrage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;

/**
 * Created by MrDeng on 2016/7/26.
 */
public class BatchSaveBarrageWorkor extends Workor{
    private static final long serialVersionUID = 728737816012587458L;
    private static final Logger logger = LoggerFactory.getLogger(BatchSaveBarrageWorkor.class);
    @Autowired
    private RedisTemplate<String, Barrage> redisTemplate;
    ArrayList<Barrage> cacheBarrage;
    @Override
    public void work() {
        logger.info("批处理弹幕存储…………START");
        System.out.println(JSON.toJSONString(cacheBarrage));
        logger.info("批处理弹幕存储…………END");
    }

    public ArrayList<Barrage> getCacheBarrage() {
        return cacheBarrage;
    }

    public void setCacheBarrage(ArrayList<Barrage> cacheBarrage) {
        this.cacheBarrage = cacheBarrage;
    }
}
