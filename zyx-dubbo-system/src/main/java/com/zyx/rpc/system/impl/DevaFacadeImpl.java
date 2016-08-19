package com.zyx.rpc.system.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.system.SystemConstants;
import com.zyx.entity.system.Devaluation;
import com.zyx.rpc.system.DevaFacade;
import com.zyx.service.account.AccountInfoService;
import com.zyx.service.activity.ActivityService;
import com.zyx.service.system.DevaService;
import com.zyx.service.live.LiveInfoService;
import com.zyx.service.pg.CircleItemService;
import com.zyx.service.pg.CircleService;
import com.zyx.service.pg.MyConcernService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MrDeng on 2016/8/3.
 */

@Service("devaFacade")
public class DevaFacadeImpl implements DevaFacade {

    @Autowired
    RedisTemplate<String, List> devaTemplate;
    @Autowired
    RedisTemplate<String, List<Devaluation>> innerDevaTemplate;
    @Autowired
    RedisTemplate<String, List<Integer>> innerDevaIdTemplate;
    @Autowired
    DevaService devaService;
    @Autowired
    LiveInfoService liveInfoService;
    @Autowired
    ActivityService activityService;
    @Autowired
    AccountInfoService accountInfoService;
    @Autowired
    CircleService circleService;
    @Autowired
    CircleItemService circleItemService;
    @Autowired
    MyConcernService myConcernService;
    @Override
    public List getDevaByModel(Integer area,Integer model) {
        //// TODO: 2016/8/3 判定Model范围
        if (model == null) {
            return null;
        }
        List devas = devaTemplate.opsForValue().get(SystemConstants.MAKE_REDIS_DEVA+area+":" + model);
        if (devas == null || devas.isEmpty()) {//Redis无该模块Deva数据
            List<Devaluation> innerDevas = innerDevaTemplate.opsForValue().get(SystemConstants.MAKE_REDIS_INNER_DEVA +area+":" + model);
            List<Integer> innerDevaIds = innerDevaIdTemplate.opsForValue().get(SystemConstants.MAKE_REDIS_INNER_DEVA_ID +area+":" + model);
            if (innerDevas == null || innerDevas.isEmpty() || innerDevaIds == null || innerDevaIds.isEmpty()) {//Redis中间表缓存无数据
                return queryAndRefreshFromDB(area,model);//刷新流程
            } else {
                devas = queryModelDevas(area,model,innerDevaIds);
                if (devas == null || devas.isEmpty()) {//DB 对应模块无数据
                    return queryAndRefreshFromDB(area,model);//刷新流程
                }
                devaTemplate.opsForValue().set(SystemConstants.MAKE_REDIS_DEVA +area+":" + model, devas);
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
    private List queryAndRefreshFromDB(Integer area,Integer model) {
        List<Integer> innerDevaIds = devaService.selectModelIds(area,model);
        List<Devaluation> innerDevas = devaService.selectDevas(area,model);
        if (innerDevas == null || innerDevas.isEmpty() || innerDevaIds == null || innerDevaIds.isEmpty()) {//DB 中间表无数据
            return null;
        }
        List devas = queryModelDevas( area, model,innerDevaIds);//DB查询
        if (devas == null || devas.isEmpty()) {//DB 对应模块无数据
            return null;
        }
        //刷新Redis
        innerDevaTemplate.opsForValue().set(SystemConstants.MAKE_REDIS_INNER_DEVA +area+":" + model, innerDevas);
        innerDevaIdTemplate.opsForValue().set(SystemConstants.MAKE_REDIS_INNER_DEVA_ID +area+":" + model, innerDevaIds);
        devaTemplate.opsForValue().set(SystemConstants.MAKE_REDIS_DEVA +area+":" + model, devas);
        return devas;
    }

    /**
     * 获取各个模块的Deva
     *
     * @param model
     * @param ids
     * @return
     */
    private List queryModelDevas(Integer area,Integer model, List<Integer>  ids) {
        switch (model){
            case Constants.MODEL_ACTIVITY:
                return activityService.selectByIds(ids);
            case Constants.MODEL_LIVE:
                return liveInfoService.selectByIds(ids);
            case Constants.MODEL_CIRCLE:
                return circleService.selectByIds(ids);
            case Constants.MODEL_CIRCLE_ITEM:
                return circleItemService.selectByIds(ids);
            case Constants.MODEL_CONCERN:
                return myConcernService.selectByIds(ids);
//            case Constants.MODEL_SHOP:
//                break;
            case Constants.MODEL_USER:
                return accountInfoService.selectBaseInfo(ids);
            case Constants.MODEL_SYSTEM:
                break;
        }
        return null;
    }

    @Override
    public List getAllDeva() {
        return null;
    }
}
