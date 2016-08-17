package com.zyx.rpc.attention.impl;

import com.zyx.constants.account.AccountConstants;
import com.zyx.constants.attention.UserAttentionConstants;
import com.zyx.entity.attention.UserAttention;
import com.zyx.param.attention.AttentionParam;
import com.zyx.rpc.attention.UserAttentionFacade;
import com.zyx.service.attention.UserAttentionService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.account.AccountAttentionVo;
import com.zyx.vo.attention.AttentionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wms on 2016/8/15.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserAttentionFacadeImpl.java
 */
@Service("userAttentionFacade")
public class UserAttentionFacadeImpl implements UserAttentionFacade {

    @Autowired
    private UserAttentionService userAttentionService;

    @Autowired
    protected RedisTemplate<String, String> stringRedisTemplate;

    @Override
    public Map<String, Object> attentionFromAToB(AttentionParam attentionParam) {
        String token = attentionParam.getToken();
        // 判断token是否失效
        if (isTokenFailure(token)) {
            return UserAttentionConstants.MAP_TOKEN_FAILURE;
        }
        try {
            UserAttention _attention = buildUserAttention(attentionParam);
            int result = userAttentionService.save(_attention);
            if (result == 1) {// 成功
                return MapUtils.buildSuccessMap(UserAttentionConstants.SUCCESS, UserAttentionConstants.SUCCESS_MSG, result);
            } else {
                return MapUtils.buildErrorMap(UserAttentionConstants.ATTENTION_70001, UserAttentionConstants.ATTENTION_70001_MSG);
            }
        } catch (Exception e) {
            return UserAttentionConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> myFSList(AttentionParam attentionParam) {
        String token = attentionParam.getToken();
        // 判断token是否失效
        if (isTokenFailure(token)) {
            return UserAttentionConstants.MAP_TOKEN_FAILURE;
        }

        try {
            List<AttentionVo> _list = userAttentionService.myFSList(attentionParam);
            return getStringObjectMap(_list);
        } catch (Exception e) {
            return UserAttentionConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> myGZList(AttentionParam attentionParam) {
        String token = attentionParam.getToken();
        // 判断token是否失效
        if (isTokenFailure(token)) {
            return UserAttentionConstants.MAP_TOKEN_FAILURE;
        }

        try {
            List<AttentionVo> _list = userAttentionService.myGZList(attentionParam);
            return getStringObjectMap(_list);
        } catch (Exception e) {
            return UserAttentionConstants.MAP_500;
        }
    }

    private Map<String, Object> getStringObjectMap(List<AttentionVo> _list) {
        if (_list == null) {
            return MapUtils.buildErrorMap(UserAttentionConstants.ATTENTION_70002, UserAttentionConstants.ATTENTION_70002_MSG);
        } else {
            List<AccountAttentionVo> _temp = new ArrayList<>();
            for (AttentionVo vo : _list) {
                _temp.addAll(vo.getAttentions());
            }
            return MapUtils.buildSuccessMap(_temp);
        }
    }

    private UserAttention buildUserAttention(AttentionParam param) {
        UserAttention _temp = new UserAttention();
        _temp.setFromUserId(param.getFromId());
        _temp.setToUserId(param.getToId());
        _temp.setRelType(param.getType());
        _temp.setCreateTime(System.currentTimeMillis());
        return _temp;
    }

    private boolean isTokenFailure(String token) {
        if (StringUtils.isEmpty(token)) {
            return true;
        }
        String phone = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
        return StringUtils.isEmpty(phone);
    }
}
