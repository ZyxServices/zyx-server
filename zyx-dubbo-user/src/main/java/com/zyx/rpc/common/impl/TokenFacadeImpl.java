package com.zyx.rpc.common.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.account.AccountConstants;
import com.zyx.manager.TokenManager;
import com.zyx.rpc.common.TokenFacade;
import com.zyx.service.account.AccountRedisService;
import com.zyx.token.TokenModel;
import com.zyx.utils.MapUtils;
import com.zyx.vo.account.AccountInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * Created by wms on 2016/7/6.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 */
@Service("tokenFacade")
public class TokenFacadeImpl implements TokenFacade {

    @Autowired
    private TokenManager manager;

    @Autowired
    protected RedisTemplate<String, String> stringRedisTemplate;

    @Autowired
    private AccountRedisService accountRedisService;

    @Override
    public boolean preHandle(String anthorization) {
        // 验证token
        TokenModel model = manager.getToken(anthorization);
        if (manager.checkToken(model)) {
            System.out.println(model.getToken());
            return true;
        }
        return true;
    }

    @Override
    public boolean isTokenFailure(String token) {
        if (StringUtils.isEmpty(token)) {
            return true;
        }
        String phone = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
        return StringUtils.isEmpty(phone);
    }

    @Override
    public boolean isTokenFailure(String token, Integer userId) {
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(userId)) {
            return true;
        }
        String phone = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
        if (StringUtils.isEmpty(phone)) {
            return true;
        }

        AccountInfoVo vo = accountRedisService.get(phone);

        return vo == null || !vo.getId().equals(userId);
    }

    @Override
    public Map<String, Object> validateToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return Constants.MAP_PARAM_MISS;
        }

        String phone = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
        if (StringUtils.isEmpty(phone)) {
            return Constants.MAP_TOKEN_FAILURE;
        }

        return null;
    }

    @Override
    public Map<String, Object> validateToken(String token, Integer userId) {
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(userId)) {
            return Constants.MAP_PARAM_MISS;
        }

        String phone = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
        if (StringUtils.isEmpty(phone)) {
            return Constants.MAP_TOKEN_FAILURE;
        }

        AccountInfoVo vo = accountRedisService.get(phone);
        if (vo == null || !vo.getId().equals(userId)) {
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50301, AccountConstants.ACCOUNT_ERROR_CODE_50301_MSG);
        }

        return null;
    }

    @Override
    public Map<String, Object> validateTokenIncludeOther(String token, Integer userId) {
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(userId)) {
            return Constants.MAP_PARAM_MISS;
        }

        if (isOtherToken(token)) {
            return null;
        }

        String phone = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
        if (StringUtils.isEmpty(phone)) {
            return Constants.MAP_TOKEN_FAILURE;
        }

        AccountInfoVo vo = accountRedisService.get(phone);
        if (vo == null || !vo.getId().equals(userId)) {
            return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50301, AccountConstants.ACCOUNT_ERROR_CODE_50301_MSG);
        }

        return null;
    }

    private boolean isOtherToken(String token) {
        return Constants.OTHER_TOKEN.equals(token);
    }
}
