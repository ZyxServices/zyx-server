package com.zyx.rpc.account.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.account.AccountConstants;
import com.zyx.rpc.account.MyCircleFacade;
import com.zyx.rpc.common.TokenFacade;
import com.zyx.service.pg.CircleService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.pg.CircleListVo;
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
 * @         MyCircleFacadeImpl.java
 */
@Service("myCircleFacade")
public class MyCircleFacadeImpl implements MyCircleFacade {

    @Autowired
    private CircleService circleService;

    @Autowired
    private TokenFacade tokenFacade;

    @Override
    public Map<String, Object> myCircleList(String token, Integer accountId) {
        try {

            // 判断token是否失效
            if (isTokenFailure(token)) {
                return AccountConstants.MAP_TOKEN_FAILURE;
            }
            List<CircleListVo> _list_create = new ArrayList<>();
            try {
                _list_create = circleService.myCreateList(accountId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            List<CircleListVo> _list_concern = new ArrayList<>();
            try {
                _list_concern = circleService.myConcernList(accountId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Map<String, Object> _temp = new HashMap<>();
            _temp.put("myCreateCircle", _list_create);
            _temp.put("myConcernCircle", _list_concern);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.SUCCESS_MSG, _temp);
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> myCreateList(String token, Integer createId) {
        try {
            // 判断token是否失效
            if (isTokenFailure(token)) {
                return AccountConstants.MAP_TOKEN_FAILURE;
            }
            List<CircleListVo> _list = circleService.myCreateList(createId);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.SUCCESS_MSG, _list);
        } catch (Exception e) {
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> myConcernList(String token, Integer createId) {
        try {
            // 判断token是否失效
            if (isTokenFailure(token)) {
                return AccountConstants.MAP_TOKEN_FAILURE;
            }
            List<CircleListVo> _list = circleService.myConcernList(createId);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.SUCCESS_MSG, _list);
        } catch (Exception e) {
            return Constants.MAP_500;
        }
    }
}
