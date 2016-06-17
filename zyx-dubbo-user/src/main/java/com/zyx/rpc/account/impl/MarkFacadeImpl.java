package com.zyx.rpc.account.impl;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.json.JSONArray;
import com.alibaba.dubbo.common.json.JSONObject;
import com.alibaba.dubbo.common.json.ParseException;
import com.zyx.constants.Constants;
import com.zyx.constants.account.AccountConstants;
import com.zyx.entity.account.UserMarkInfo;
import com.zyx.entity.account.param.UserMarkParam;
import com.zyx.rpc.account.MarkFacade;
import com.zyx.service.account.UserMarkService;
import com.zyx.utils.DateUtils;
import com.zyx.vo.account.MarkInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by WeiMinSheng on 2016/6/16.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title MarkFacadeImpl.java
 */
@Service("markFacade")
public class MarkFacadeImpl implements MarkFacade {

    @Autowired
    private UserMarkService userMarkService;

    @Autowired
    protected RedisTemplate<String, String> jedisTemplate;

    @Override
    public Map<String, Object> sign(UserMarkParam userMarkParam) {
        Map<String, Object> map = new HashMap<String, Object>();
        String phone = jedisTemplate.opsForValue().get("tyj_token:" + userMarkParam.getToken());
        if (phone == null) {// token失效
            map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50000);
            map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50000_MSG);
            return map;
        }
        // 查询用户签到信息
        MarkInfoVo markInfoVo = null;
        try {
            markInfoVo = userMarkService.queryMarkInfo(userMarkParam);
        } catch (Exception e) {
            map = AccountConstants.MAP_500;
        }
        if (markInfoVo != null) {// 查询到进行更新
            modifyMarkInfo(map, userMarkParam, markInfoVo);
        } else {
            map = insertMarkInfo(map, userMarkParam);
        }
        return map;
    }

    @Override
    public Map<String, Object> querySign(UserMarkParam userMarkParam) {
        Map<String, Object> map = new HashMap<String, Object>();
        String phone = jedisTemplate.opsForValue().get("tyj_token:" + userMarkParam.getToken());
        if (phone == null) {// token失效
            map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50000);
            map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50000_MSG);
            return map;
        }
        // 查询用户签到信息
        MarkInfoVo markInfoVo;
        try {
            markInfoVo = userMarkService.queryMarkInfo(userMarkParam);
            if (markInfoVo != null) {
                map.put(Constants.STATE, Constants.SUCCESS);
                map.put(AccountConstants.MARK_INFO, markInfoVo);
            } else {
                map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50202);
                map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50202_MSG);
            }
        } catch (Exception e) {
            map = AccountConstants.MAP_500;
        }
        return map;
    }

    private Map<String, Object> modifyMarkInfo(Map<String, Object> map, UserMarkParam userMarkParam, MarkInfoVo markInfoVo) {
        Timestamp lastModifyTimeStamp = new Timestamp(markInfoVo.getMarkTime());
        Timestamp todayStartTimeStamp = DateUtils.getTodayStartTimeStamp();
        if (lastModifyTimeStamp.after(todayStartTimeStamp)) {// 今天已经签过到了
            map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50201);
            map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50201_MSG);
        } else {
            Long t = System.currentTimeMillis();
            final long missDays = DateUtils.getMissDay(t, markInfoVo.getMarkTime());
            if (missDays == 1) {//连续签到，连续签到次数增加1 ，签到历史移动一位
                userMarkParam.setMarkCount(markInfoVo.getMarkCount() + 1);
            } else {
                userMarkParam.setMarkCount(1);
            }
            userMarkParam.setMarkTime(t);
            userMarkParam.setId(markInfoVo.getId());

            try {
                userMarkParam.setMarkHistory(getMarkHistory(markInfoVo.getMarkHistory(), t));
                int result = userMarkService.updateMarkInfo(userMarkParam);
                if (result >= 1) {
                    map.put(Constants.STATE, Constants.SUCCESS);
                } else {
                    map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50203);
                    map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50203_MSG);
                }
            } catch (Exception e) {
                map = AccountConstants.MAP_500;
            }

        }

        return map;
    }

    private Map<String, Object> insertMarkInfo(Map<String, Object> map, UserMarkParam userMarkParam) {
        UserMarkInfo userMarkInfo = new UserMarkInfo();
        Long t = System.currentTimeMillis();
        userMarkInfo.setMarkTime(t);
        userMarkInfo.setMarkCount(1);
        userMarkInfo.setCreateTime(t);
        userMarkInfo.setUserId(userMarkParam.getUserId());
        try {
            String history = getMarkHistory(t);
            userMarkInfo.setMarkHistory(history);
            int result = userMarkService.save(userMarkInfo);
            if (result >= 1) {
                map.put(Constants.STATE, Constants.SUCCESS);
            } else {
                map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50200);
                map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50200_MSG);
            }
        } catch (IOException e) {
            map = AccountConstants.MAP_500;
        }
        return map;
    }

    /**
     * 创建时
     *
     * @param t
     * @return
     * @throws IOException
     */
    private String getMarkHistory(Long t) throws IOException {
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        int[] days = new int[400];
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(t);
        days[calendar.get(Calendar.DAY_OF_YEAR)] = 1;
        map.put(calendar.get(Calendar.YEAR), days);
        return JSON.json(map);
    }

    /**
     * 更新时
     *
     * @param markHistory
     * @param t
     * @return
     * @throws IOException
     */
    private String getMarkHistory(String markHistory, Long t) throws Exception {
        Map<String, Object> map = JSON.parse(markHistory, Map.class);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(t);
        if (map.get(calendar.get(Calendar.YEAR) + "") == null) {
            int[] days = new int[400];
            days[calendar.get(Calendar.DAY_OF_YEAR)] = 1;
            map.put(calendar.get(Calendar.YEAR) + "", days);
        } else {
            ArrayList days = (ArrayList) map.get(calendar.get(Calendar.YEAR) + "");
            days.set(calendar.get(Calendar.DAY_OF_YEAR), 1L);
            map.put(calendar.get(Calendar.YEAR) + "", days);
        }
        return JSON.json(map);
    }

}
