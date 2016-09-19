package com.zyx.rpc.account.impl;

import com.zyx.constants.Constants;
import com.zyx.rpc.account.MyCircleFacade;
import com.zyx.rpc.common.TokenFacade;
import com.zyx.service.pg.CircleService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.pg.CircleListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            Map<String, Object> map = tokenFacade.validateToken(token, accountId);
            if (map != null) {
                return map;
            }
//            List<CircleListVo> _list_create = new ArrayList<>();
//            try {
//                _list_create = circleService.myCreateList(accountId);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            List<CircleListVo> list_create = new ArrayList<>();
            List<CircleListVo> list_concern = new ArrayList<>();
            try {
                List<CircleListVo> list_concern_temp = circleService.myConcernList(accountId);
                list_concern_temp.forEach(x -> {
                if (x.getCreateId().equals(accountId)) {
                    list_create.add(x);
                } else {
                    list_concern.add(x);
                }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            Map<String, Object> _temp = new HashMap<>();
            _temp.put("myCreateCircle", list_create);
            _temp.put("myConcernCircle", list_concern);
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
            Map<String, Object> map = tokenFacade.validateToken(token, createId);
            if (map != null) {
                return map;
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
            Map<String, Object> map = tokenFacade.validateToken(token, createId);
            if (map != null) {
                return map;
            }
            List<CircleListVo> _list = circleService.myConcernList(createId);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.SUCCESS_MSG, _list);
        } catch (Exception e) {
            return Constants.MAP_500;
        }
    }

    public static void main(String[] args) {
        List<String> aaa = new ArrayList<>();
        aaa.add("a");
        aaa.add("b");
        aaa.forEach(System.out::println);
    }
}
