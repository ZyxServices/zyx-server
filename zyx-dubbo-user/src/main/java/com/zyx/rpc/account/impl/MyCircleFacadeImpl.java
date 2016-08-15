package com.zyx.rpc.account.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.account.AccountConstants;
import com.zyx.entity.pg.dto.CircleListDto;
import com.zyx.rpc.account.MyCircleFacade;
import com.zyx.service.pg.CircleService;
import com.zyx.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wms on 2016/8/11.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title MyCircleFacadeImpl.java
 */
@Service("myCircleFacade")
public class MyCircleFacadeImpl implements MyCircleFacade {

    @Autowired
    private CircleService circleService;

    @Autowired
    protected RedisTemplate<String, String> stringRedisTemplate;

    @Override
    public Map<String, Object> myCircleList(String token, Integer accountId) {
        // 判断token是否失效
        if (isTokenFailure(token)) {
            return AccountConstants.MAP_TOKEN_FAILURE;
        }
        List<CircleListDto> _list_create = new ArrayList<CircleListDto>();
        try {
            _list_create = circleService.myCreateList(accountId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<CircleListDto> _list_concern = new ArrayList<CircleListDto>();
        try {
            _list_concern = circleService.myConcernList(accountId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Object> _temp = new HashMap<String, Object>();
        _temp.put("myCreateCircle", _list_create);
        _temp.put("myConcernCircle", _list_concern);
        return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.SUCCESS_MSG, _temp);
    }

    @Override
    public Map<String, Object> myCreateList(String token, Integer createId) {
        // 判断token是否失效
        if (isTokenFailure(token)) {
            return AccountConstants.MAP_TOKEN_FAILURE;
        }
        try {
            List<CircleListDto> _list = circleService.myCreateList(createId);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.SUCCESS_MSG, _list);

        } catch (Exception e) {
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> myConcernList(String token, Integer createId) {
        // 判断token是否失效
        if (isTokenFailure(token)) {
            return AccountConstants.MAP_TOKEN_FAILURE;
        }
        try {
            List<CircleListDto> _list = circleService.myConcernList(createId);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.SUCCESS_MSG, _list);

        } catch (Exception e) {
            return Constants.MAP_500;
        }
    }

    private boolean isTokenFailure(String token) {
        if (StringUtils.isEmpty(token)) {
            return true;
        }
        String phone = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
        return StringUtils.isEmpty(phone);
    }
}
