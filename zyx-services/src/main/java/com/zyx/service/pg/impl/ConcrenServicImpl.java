package com.zyx.service.pg.impl;


import com.zyx.constants.Constants;
import com.zyx.constants.pg.PgConstants;
import com.zyx.vo.pg.MyFollowVo;
import com.zyx.entity.pg.Concern;
import com.zyx.mapper.pg.ConcernMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.ConcernService;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by XiaoWei on 2016/6/7.
 */
@Service
public class ConcrenServicImpl extends BaseServiceImpl<Concern> implements ConcernService {

    @Resource
    private ConcernMapper concernMapper;


    public ConcrenServicImpl() {
        super(Concern.class);
    }


    @Override
    public Map<String, Object> addCern(Integer userId, Integer type, String cernTitle, String content, String cernImgurl, String videoUrl, Integer visible) {
        Map<String, Object> map = new HashMap<>();
        Concern insertCern = new Concern();
        insertCern.setCreateTime(new Date().getTime());
        Optional.ofNullable(userId).ifPresent(insertCern::setUserId);
        Optional.ofNullable(type).ifPresent(insertCern::setType);
        Optional.ofNullable(cernTitle).ifPresent(insertCern::setTopicTitle);
        Optional.ofNullable(content).ifPresent(insertCern::setTopicContent);
        Optional.ofNullable(cernImgurl).ifPresent(insertCern::setImgUrl);
        Optional.ofNullable(videoUrl).ifPresent(insertCern::setVideoUrl);
        Optional.ofNullable(visible).ifPresent(insertCern::setTopicVisible);
        insertCern.setState(0);
        save(insertCern);
        return MapUtils.buildSuccessMap(Constants.SUCCESS, PgConstants.PG_ERROR_CODE_33000_MSG, null);
//        map.put(Constants.STATE, Constants.SUCCESS);
//        return map;
    }

    @Override
    public Map<String, Object> starRandom(Integer type, Integer n) {
        Map<String, Object> map = new HashMap<>();
        try {
            Optional.ofNullable(n).orElse(10);
            List<Concern> randomList = concernMapper.starRandom(type, n);
//            map.put(Constants.STATE, Constants.MSG_SUCCESS);
//            map.put(PgConstants.PG_RESULT, Optional.ofNullable(randomList).orElse(null));
//            return map;
            return MapUtils.buildSuccessMap(Constants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, Optional.ofNullable(randomList).orElse(null));
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> getMyFollowList(Integer loginUserId) {
        try {
            if (Objects.equals(loginUserId, null)) {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30000, PgConstants.PG_ERROR_CODE_30000_MSG);
            }
            List<MyFollowVo> myFollowVos = concernMapper.myFollowList(loginUserId);
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, myFollowVos);
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }

    }

    @Override
    public List<Concern> queryMyConcernList(Integer accountId) {
        if (accountId == null) {
            return null;
        }
        return concernMapper.myConcernList(accountId);

    }

    @Override
    public Map<String, Object> starConcern(Integer max) {
        try {
            Optional.ofNullable(max).orElse(5);
            List<MyFollowVo> myFollowVos = concernMapper.starConcern(max);
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, myFollowVos);
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }

}
