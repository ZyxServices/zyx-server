package com.zyx.service.account.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.account.AccountConstants;
import com.zyx.entity.Devaluation;
import com.zyx.entity.activity.Activity;
import com.zyx.mapper.account.AccountInfoMapper;
import com.zyx.mapper.activity.DevaluationMapper;
import com.zyx.service.account.UserDevaluationService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.account.AccountInfoVo;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by skmbg on 2016/6/29.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserDevaluationServiceImpl.java
 */
@Service
public class UserDevaluationServiceImpl implements UserDevaluationService {
    @Resource
    private DevaluationMapper devaluationMapper;
    @Resource
    private AccountInfoMapper accountInfoMapper;
    @Resource
    private RedisTemplate<String, Map<String, AccountInfoVo>> redisTemplate;

    @Override
    public Map<String, Object> queryUserDeva() {
        // 查询redis
        Map<Object, Object> _entries = redisTemplate.opsForHash().entries(AccountConstants.TYJ_USER_DEVA);
        if (_entries != null && _entries.size() > 0) {
            return MapUtils.buildSuccessMap(Constants.SUCCESS, "用户首推数据查询成功->Redis", _entries.values().toArray());
        }

        List<Devaluation> devaluations = devaluationMapper.queryDevaluation(AccountConstants.USER_DEVA_MODEL);
        if (devaluations == null || devaluations.size() == 0) {
            return MapUtils.buildErrorMap(Constants.NO_DATA, "查无数据");
        }
        List<Integer> users = new ArrayList<>();
        devaluations.forEach(e -> users.add(e.getDevaluationId()));
        List<AccountInfoVo> vos = accountInfoMapper.queryUserDevaluation(users);
        if (vos == null || vos.size() == 0) {
            return MapUtils.buildErrorMap(Constants.NO_DATA, "查无数据");
        }
        Map<String, AccountInfoVo> _users_map = new HashMap<>();
        int _size = vos.size() > 10 ? 10 : vos.size();
        for (int i = 0; i < _size; i++) {
            _users_map.put(vos.get(i).getPhone(), vos.get(i));
        }
        redisTemplate.opsForHash().putAll(AccountConstants.TYJ_USER_DEVA, _users_map);
        return MapUtils.buildSuccessMap(Constants.SUCCESS, "用户首推数据查询成功->DB", vos);
    }

    @Override
    public Map<String, Object> insertUserDeva(Devaluation devaluation) {
        Devaluation _d = devaluationMapper.queryDevaluationByDevaId(AccountConstants.USER_DEVA_MODEL, devaluation.getDevaluationId());
        int insert;
        if (_d != null) {// 更新
            _d.setCreateTime(System.currentTimeMillis());
            insert = devaluationMapper.updateByPrimaryKey(_d);
        } else {
            insert = devaluationMapper.insert(devaluation);
        }
        if (insert > 0) {
            redisTemplate.delete(AccountConstants.TYJ_USER_DEVA);
            return MapUtils.buildSuccessMap(Constants.SUCCESS, "首推成功", null);
        } else {
            return MapUtils.buildErrorMap(Constants.ERROR, "首推失败");
        }
    }

}
