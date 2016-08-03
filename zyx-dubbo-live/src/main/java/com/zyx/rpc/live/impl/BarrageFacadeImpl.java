package com.zyx.rpc.live.impl;

import com.zyx.constants.live.LiveConstants;
import com.zyx.core.workors.BatchSaveBarrageWorkor;
import com.zyx.core.workors.Workor;
import com.zyx.core.workors.WorkorHelper;
import com.zyx.entity.live.Barrage;
import com.zyx.rpc.live.BarrageFacade;
import com.zyx.service.live.BarrageService;
import com.zyx.vo.live.BarrageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("barrageFacade")
public class BarrageFacadeImpl implements BarrageFacade {

    @Autowired
    BarrageService barrageService;
    @Autowired
    private RedisTemplate<String, Barrage> barrageRedis;

    @Autowired
    RedisTemplate<String, Workor> redisTemplate;

    @Autowired
    private RedisTemplate<String, Long> sizeRedis;
    @Autowired
    private WorkorHelper workorHelper;

    ArrayList<Barrage> cacheBarrage = new ArrayList<>();

    @Override
    public synchronized void add(Barrage barrage) {
        Long size = barrageRedis.opsForList().size(LiveConstants.MARK_REDIS_BARRAGE_QUEUE);
        if (size >= LiveConstants.DEFAULT_BARRAGE_QUEUE_SIZE) {
            barrageRedis.opsForList().rightPop(LiveConstants.MARK_REDIS_BARRAGE_QUEUE);
        }
        /**
         * 缓存+线程池处理
         */
        cacheBarrage.add(barrage);
        if (cacheBarrage.size() > 5) {
            BatchSaveBarrageWorkor workor = new BatchSaveBarrageWorkor();
            workor.setCacheBarrage(cacheBarrage);
            redisTemplate.opsForList().leftPush("tq", workor);
            cacheBarrage.clear();
        }

    }

    @Override
    public List<Barrage> getLast(BarrageVo barrageVo) {
        barrageVo.setStart(0);
        barrageVo.setEnd(10);
        return barrageService.getTop(barrageVo);
    }

}
