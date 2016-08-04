package com.zyx.rpc.system.impl;

import com.zyx.constants.system.SystemConstants;
import com.zyx.entity.Devaluation;
import com.zyx.entity.deva.dto.DevaDto;
import com.zyx.entity.live.LiveInfo;
import com.zyx.rpc.system.DevaFacade;
import com.zyx.service.activity.ActivityService;
import com.zyx.service.admin.DevaluationService;
import com.zyx.service.live.LiveInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * Created by MrDeng on 2016/8/3.
 */
public class DevaFacadeImpl implements DevaFacade {

    @Autowired
    RedisTemplate<String, List<DevaDto>> devaTemplate;
    @Autowired
    RedisTemplate<String, List<Devaluation>> innerDevaTemplate;
    @Autowired
    RedisTemplate<String, List<Integer>> innerDevaIdTemplate;
    @Autowired
    DevaluationService devaluationService;


    @Autowired
    LiveInfoService liveInfoService;
    @Autowired
    ActivityService activityService;
    @Override
    public List<DevaDto> getDevaByModel(Integer model) {
        //// TODO: 2016/8/3 判定Model范围
        if (model == null) {
            return null;
        }
        List<DevaDto> devas = devaTemplate.opsForValue().get(SystemConstants.MAKE_REDIS_DEVA + model);
        if (devas == null || devas.isEmpty()) {//Redis无该模块Deva数据
            List<Devaluation> innerDevas = innerDevaTemplate.opsForValue().get(SystemConstants.MAKE_REDIS_INNER_DEVA + model);
            List<Integer> innerDevaIds = innerDevaIdTemplate.opsForValue().get(SystemConstants.MAKE_REDIS_INNER_DEVA_ID + model);
            if (innerDevas == null || innerDevas.isEmpty() || innerDevaIds == null || innerDevaIds.isEmpty()) {//Redis中间表缓存无数据
                return queryAndRefreshFromDB(model);//刷新流程
            } else {
                devas = queryModelDevas(model,innerDevaIds);
                if (devas == null || devas.isEmpty()) {//DB 对应模块无数据
                    return queryAndRefreshFromDB(model);//刷新流程
                }
                devaTemplate.opsForValue().set(SystemConstants.MAKE_REDIS_DEVA + model, devas);
                return devas;
            }
        }
        return devas;
    }

    /**
     * 全部从数据库刷新
     *
     * @param model
     * @return
     */
    private List queryAndRefreshFromDB(Integer model) {
        List<Integer> innerDevaIds = devaluationService.queryDevaIds(model);
        List<Devaluation> innerDevas = devaluationService.queryDevaluation(model);
        if (innerDevas == null || innerDevas.isEmpty() || innerDevaIds == null || innerDevaIds.isEmpty()) {//DB 中间表无数据
            return null;
        }
        List<DevaDto> devas = queryModelDevas(model,innerDevaIds);//DB查询
        if (devas == null || devas.isEmpty()) {//DB 对应模块无数据
            return null;
        }
        //刷新Redis
        innerDevaTemplate.opsForValue().set(SystemConstants.MAKE_REDIS_INNER_DEVA + model, innerDevas);
        innerDevaIdTemplate.opsForValue().set(SystemConstants.MAKE_REDIS_INNER_DEVA_ID + model, innerDevaIds);
        devaTemplate.opsForValue().set(SystemConstants.MAKE_REDIS_DEVA + model, devas);
        return devas;
    }

    /**
     * 获取各个模块的Deva
     *
     * @param model
     * @param ids
     * @return
     */
    private List queryModelDevas(Integer model, List<Integer>  ids) {
        switch (model){
            case 1:
//                return activityService.sele
            case 2:
                return liveInfoService.selectLiveDevas(ids);
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }
        return null;
    }

    @Override
    public List<DevaDto> getAllDeva() {
        return null;
    }
}
