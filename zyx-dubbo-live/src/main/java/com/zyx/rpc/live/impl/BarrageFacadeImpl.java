package com.zyx.rpc.live.impl;

import com.zyx.constants.live.LiveConstants;
import com.zyx.entity.live.Barrage;
import com.zyx.param.live.BarrageParam;
import com.zyx.rpc.live.BarrageFacade;
import com.zyx.service.live.BarrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("barrageFacade")
public class BarrageFacadeImpl implements BarrageFacade {

    @Autowired
    BarrageService barrageService;
    @Autowired
    private RedisTemplate<String, Barrage> barrageRedis;
//    @Autowired
//    RedisTemplate<String, Workor> redisTemplate;
    //    @Autowired
    //    private RedisTemplate<String, Long> barrageSizeRedis;
//    @Autowired
//    SpringContextUtil springContextUtil;

//    ConcurrentHashMap<Integer, Long> barrageSizeMap = new ConcurrentHashMap<>();
//    ConcurrentHashMap<Integer, ArrayList<Barrage>> cacheBarrage = new ConcurrentHashMap<Integer, ArrayList<Barrage>>();
    @Override
    public void add(Barrage barrage) {
        if (barrage == null || barrage.getLiveId() == null)
            return;
        Long size = barrageRedis.opsForList().size(LiveConstants.MARK_REDIS_BARRAGE_QUEUE + barrage.getLiveId());
        if (size >= LiveConstants.REDIS_MAX_BARRAGE_QUEUE_SIZE) {
            barrageRedis.opsForList().rightPop(LiveConstants.MARK_REDIS_BARRAGE_QUEUE + barrage.getLiveId());
        }
        barrageRedis.opsForList().leftPush(LiveConstants.MARK_REDIS_BARRAGE_QUEUE + barrage.getLiveId(), barrage);
        barrageService.save(barrage);
        /**
         * 缓存+线程池处理
         */
//        ArrayList<Barrage> barrageList = cacheBarrage.get(barrage.getLiveId());
//        Long bsize = barrageSizeMap.get(barrage.getLiveId());
//        if (barrageList == null || bsize == null) {
//            barrageList = new ArrayList<Barrage>();
//            bsize = 0L;
//        }
//        barrageList.add(barrage);
//        bsize++;
//        cacheBarrage.put(barrage.getLiveId(), barrageList);
//        barrageSizeMap.put(barrage.getLiveId(), bsize);
//        if (barrageList.size() > LiveConstants.CACHE_BATACH_SAVE_PROFIXE) {//LiveConstants.CACHE_BATACH_SAVE_PROFIXE
//            BatchSaveBarrageWorkor workor = new BatchSaveBarrageWorkor();
//            ArrayList<Barrage> batchList = new ArrayList<>(barrageList);
//            workor.setContext(springContextUtil.getApplicationContext());
//            workor.setCacheBarrage(batchList);
//            globalThreadPool.submitWorkor(workor);
//            barrageList.clear();
//        }
    }

    @Override
    public List<Barrage> getLast(BarrageParam param) {
//        if (param == null || param.getLiveId() == null)
//            return null;
        Long size = barrageRedis.opsForList().size(LiveConstants.MARK_REDIS_BARRAGE_QUEUE + param.getLiveId());
//        List<Barrage> barrages;
        Map result = new HashMap<String, Object>();
//        Long nowIndex = barrageSizeMap.get(param.getLiveId());
//        if (nowIndex == null) {
//            result.put("size", 0);
//            result.put("barrages", null);
//            nowIndex=0L;
//        } else {
//            if (param.getIndex() == null) {
//                System.out.println("全拿");
//                barrages = barrageRedis.opsForList().range(LiveConstants.MARK_REDIS_BARRAGE_QUEUE + param.getLiveId(), 0, size);
//            } else {
//                long end = 1-(nowIndex - param.getIndex()) > LiveConstants.REDIS_MAX_BARRAGE_QUEUE_SIZE ? LiveConstants.REDIS_MAX_BARRAGE_QUEUE_SIZE : (nowIndex - param.getIndex());
//                System.out.println("拿部分：0 " + end);
//                barrages = barrageRedis.opsForList().range(LiveConstants.MARK_REDIS_BARRAGE_QUEUE + param.getLiveId(), 1, end);
//            }
//            result.put("size", barrages == null ? 0 : barrages.size());
//            result.put("barrages", barrages);
//        }
        List<Barrage> barrages = barrageRedis.opsForList().range(LiveConstants.MARK_REDIS_BARRAGE_QUEUE + param.getLiveId(), 0, size);
        return barrages;
    }

    @Override
    public void endLiveCleanBarrage(BarrageParam param) {
        if (param == null || param.getLiveId() == null)
            return;
//        cacheBarrage.remove(param.getLiveId());
    }

}
