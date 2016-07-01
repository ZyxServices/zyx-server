package com.zyx.service.pg.impl;


import com.zyx.constants.Constants;
import com.zyx.constants.pg.PgConstants;
import com.zyx.mapper.activity.DevaluationMapper;
import com.zyx.mapper.pg.ConcernMapper;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;

import com.zyx.entity.pg.Concern;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.ConcrenService;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by XiaoWei on 2016/6/7.
 */
@Service
public class ConcrenServicImpl extends BaseServiceImpl<Concern> implements ConcrenService {

    @Resource
    private ConcernMapper concernMapper;

    @Resource
    DevaluationMapper devaluationMapper;

    @Override
    public Map<String, Object> addCern(Integer userId, Integer type, String cernTitle, String content, String cernImgurl, String videoUrl, Integer visible) {
        Map<String, Object> map = new HashMap<>();
        try {
            Concern insertCern = new Concern();
            insertCern.setCreateTime(new Date().getTime());
            Optional.ofNullable(userId).ifPresent(insertCern::setUser_id);
            Optional.ofNullable(type).ifPresent(insertCern::setType);
            Optional.ofNullable(cernTitle).ifPresent(insertCern::setTopic_title);
            Optional.ofNullable(content).ifPresent(insertCern::setTopic_content);
            Optional.ofNullable(cernImgurl).ifPresent(insertCern::setImg_url);
            Optional.ofNullable(videoUrl).ifPresent(insertCern::setVideo_url);
            Optional.ofNullable(visible).ifPresent(insertCern::setTopic_visible);
            save(insertCern);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, PgConstants.PG_ERROR_CODE_33000_MSG, null);
//            map.put(Constants.STATE, Constants.SUCCESS);
//            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
//            map.put(Constants.STATE, Constants.ERROR_500);
        }
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
    public List<Concern> queryConcernDeva() {
        List<Long> ids = devaluationMapper.queryDevaIds(3);
        if (ids != null && ids.size() > 0) {
            List<Concern> list = concernMapper.queryConcernDeva(ids);
            return list;
        }
        return null;
    }
}
