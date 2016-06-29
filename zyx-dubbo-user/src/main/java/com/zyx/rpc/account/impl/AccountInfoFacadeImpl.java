package com.zyx.rpc.account.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.account.AccountConstants;
import com.zyx.entity.account.UserLoginParam;
import com.zyx.rpc.account.AccountInfoFacade;
import com.zyx.service.account.AccountInfoService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.account.AccountInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by WeiMinSheng on 2016/6/17.
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
    protected RedisTemplate<String, String> jedisTemplate;

    @Override
    public Map<String, Object> queryAccountInfo(String token, int userId) {
        String phone = jedisTemplate.opsForValue().get("tyj_token:" + token);
        if (phone == null) {// token失效
            return Constants.MAP_TOKEN_FAILURE;
        }

        UserLoginParam userLoginParam = new UserLoginParam();
        userLoginParam.setToken(token);
        userLoginParam.setId(userId);
        try {
            List<AccountInfoVo> list = accountInfoService.selectAccountByParam(userLoginParam);
            if (list == null || list.size() == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50300, AccountConstants.ACCOUNT_ERROR_CODE_50300_MSG);
            } else {
                AccountInfoVo accountInfo = list.get(0);
                if (accountInfo.getPhone().equals(phone)) {
                    return MapUtils.buildSuccessMap(Constants.SUCCESS, "用户信息查询成功", accountInfo);
                }
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50301, AccountConstants.ACCOUNT_ERROR_CODE_50301_MSG);
            }
        } catch (Exception e) {
            return Constants.MAP_500;
        }
    }
}
