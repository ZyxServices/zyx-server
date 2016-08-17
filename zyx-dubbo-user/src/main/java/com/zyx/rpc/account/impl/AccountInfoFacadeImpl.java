package com.zyx.rpc.account.impl;

import com.zyx.constants.account.AccountConstants;
import com.zyx.entity.account.UserLoginParam;
import com.zyx.entity.account.param.AccountInfoParam;
import com.zyx.rpc.account.AccountInfoFacade;
import com.zyx.service.account.AccountInfoService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.account.AccountInfoVo;
import com.zyx.vo.account.MyCenterInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by wms on 2016/6/17.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AccountInfoFacadeImpl.java
 */
@Service("accountInfoFacade")
public class AccountInfoFacadeImpl implements AccountInfoFacade {

    @Autowired
    private AccountInfoService accountInfoService;

    @Autowired
    protected RedisTemplate<String, String> stringRedisTemplate;

    @Override
    public Map<String, Object> queryAccountInfo(String token, int userId) {
        try {
            // 判断token是否失效
            if (isTokenFailure(token)) {
                return AccountConstants.MAP_TOKEN_FAILURE;
            }
            UserLoginParam userLoginParam = new UserLoginParam();
            userLoginParam.setToken(token);
            userLoginParam.setId(userId);
            List<AccountInfoVo> list = accountInfoService.selectAccountByParam(userLoginParam);
            if (list == null || list.size() == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50300, AccountConstants.ACCOUNT_ERROR_CODE_50300_MSG);
            } else {
                AccountInfoVo accountInfo = list.get(0);
                // 获取token相关的手机号码
                String phone = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
                if (accountInfo.getPhone().equals(phone)) {
                    return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "用户信息查询成功", accountInfo);
                }
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50301, AccountConstants.ACCOUNT_ERROR_CODE_50301_MSG);
            }
        } catch (Exception e) {
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> editAccountInfo(String token, int userId, AccountInfoParam param) {
        try {
            // 判断token是否失效
            if (isTokenFailure(token)) {
                return AccountConstants.MAP_TOKEN_FAILURE;
            }
            param.setId(userId);
            param.setToken(token);
            int result = accountInfoService.updateAccountByParam(param);
            if (result >= 1) {
                return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "用户信息修改成功", null);
            } else {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50002, AccountConstants.ACCOUNT_ERROR_CODE_50002_MSG);
            }
        } catch (Exception e) {
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> queryMyCenterInfo(String token, int userId) {
        try {
            // 判断token是否失效
            if (isTokenFailure(token)) {
                return AccountConstants.MAP_TOKEN_FAILURE;
            }
            UserLoginParam userLoginParam = new UserLoginParam();
            userLoginParam.setId(userId);
            MyCenterInfoVo _info = accountInfoService.queryMyCenterInfo(userLoginParam);
            if (_info == null) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50300, AccountConstants.ACCOUNT_ERROR_CODE_50300_MSG);
            } else {
                // 获取token相关的手机号码
                String phone = stringRedisTemplate.opsForValue().get(AccountConstants.REDIS_KEY_TYJ_TOKEN + token);
                if (_info.getPhone().equals(phone)) {
                    return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "用户信息查询成功", _info);
                }
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50301, AccountConstants.ACCOUNT_ERROR_CODE_50301_MSG);
            }
        } catch (Exception e) {
            return AccountConstants.MAP_500;
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
