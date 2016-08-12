package com.zyx.rpc.account.impl;

import com.zyx.constants.Constants;
import com.zyx.entity.pg.dto.CircleListDto;
import com.zyx.rpc.account.MyCircleFacade;
import com.zyx.service.pg.CircleService;
import com.zyx.utils.MapUtils;
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
 * @title MyCircleFacadeImpl.java
 */
@Service("myCircleFacade")
public class MyCircleFacadeImpl implements MyCircleFacade {

    @Autowired
    private CircleService circleService;

    @Override
    public Map<String, Object> myCircleList(Integer accountId) {
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
    public Map<String, Object> myCreateList(Integer createId) {
        try {

            List<CircleListDto> _list = circleService.myCreateList(createId);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.SUCCESS_MSG, _list);

        } catch (Exception e) {
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> myConcernList(Integer createId) {
        try {

            List<CircleListDto> _list = circleService.myConcernList(createId);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, Constants.SUCCESS_MSG, _list);

        } catch (Exception e) {
            return Constants.MAP_500;
        }
    }
}
