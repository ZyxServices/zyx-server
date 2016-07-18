package com.zyx.rpc.live.impl;

import com.zyx.constants.live.LiveConstants;
import com.zyx.entity.live.LiveLab;
import com.zyx.rpc.live.LiveLabFacade;
import com.zyx.service.live.LiveLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("liveLabFacade")
public class LiveLabFacadeImpl implements LiveLabFacade {

    @Autowired
    LiveLabService liveTypeService;
    @Autowired
    private RedisTemplate<String, ArrayList<LiveLab>> redisTemplate;


    @Override
    public List<String> getAllLabs() {
        List<String> list = (List<String>) redisTemplate.opsForHash().get(LiveConstants.MARK_REDIS_LIVE_TYPE_LIST, LiveConstants.MARK_HASH_REDIS_LIVE_TYPE_LIST);
        if (null==list||list.isEmpty()){
            list = liveTypeService.getAllTypes();
            if(null!=list&&!list.isEmpty())
                redisTemplate.opsForHash().put(LiveConstants.MARK_REDIS_LIVE_TYPE_LIST, LiveConstants.MARK_HASH_REDIS_LIVE_TYPE_LIST,list);
        }
        return list;
    }
}
