package com.zyx.rpc.account.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.account.AccountConstants;
import com.zyx.entity.account.param.UserAddressParam;
import com.zyx.rpc.account.AccountAddressFacade;
import com.zyx.service.account.AccountAddressInfoService;
import com.zyx.vo.account.UserAddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WeiMinSheng on 2016/6/21.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AccountAddressFacadeImpl.java
 */
@Service("accountAddressFacade")
public class AccountAddressFacadeImpl implements AccountAddressFacade {

    @Autowired
    private AccountAddressInfoService accountAddressInfoService;

    @Autowired
    protected RedisTemplate<String, String> jedisTemplate;

    @Override
    public Map<String, Object> insertAccountAddressInfo(UserAddressParam param) {
        Map<String, Object> map = new HashMap<String, Object>();

        String phone = jedisTemplate.opsForValue().get("tyj_token:" + param.getToken());
        if (phone == null) {// token失效
            return AccountConstants.MAP_TOKEN_FAILURE;
        }
        try {
            int result = accountAddressInfoService.insertAccountAddressInfo(param);
            if (result == 0) {
                map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50400);
                map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50400_MSG);
            } else {
                map.put(Constants.STATE, Constants.SUCCESS);
            }
            return map;
        } catch (Exception e) {
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> queryAccountAddressInfo(UserAddressParam param) {
        Map<String, Object> map = new HashMap<String, Object>();

        String phone = jedisTemplate.opsForValue().get("tyj_token:" + param.getToken());
        if (phone == null) {// token失效
            return AccountConstants.MAP_TOKEN_FAILURE;
        }
        try {
            UserAddressVo userAddressVo = accountAddressInfoService.selectAddressByAddressId(param);
            if (userAddressVo == null) {
                map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50300);
                map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50300_MSG);
            } else {
                map.put(Constants.STATE, Constants.SUCCESS);
                map.put("result", userAddressVo);
            }
            return map;
        } catch (Exception e) {
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> queryAccountAddressList(UserAddressParam param) {
        Map<String, Object> map = new HashMap<String, Object>();

        String phone = jedisTemplate.opsForValue().get("tyj_token:" + param.getToken());
        if (phone == null) {// token失效
            return AccountConstants.MAP_TOKEN_FAILURE;
        }
        try {
            List<UserAddressVo> result = accountAddressInfoService.selectAddressList(param);
            if (result == null || result.size() == 0) {
                map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50300);
                map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50300_MSG);
            } else {
                map.put(Constants.STATE, Constants.SUCCESS);
                map.put("result", result);
            }
            return map;
        } catch (Exception e) {
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> deleteAccountAddressInfo(UserAddressParam param) {
        Map<String, Object> map = new HashMap<String, Object>();

        String phone = jedisTemplate.opsForValue().get("tyj_token:" + param.getToken());
        if (phone == null) {// token失效
            return AccountConstants.MAP_TOKEN_FAILURE;
        }
        try {
            int result = accountAddressInfoService.deleteByAddressId(param);
            if (result == 0) {
                map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50401);
                map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50401_MSG);
            } else {
                map.put(Constants.STATE, Constants.SUCCESS);
            }
            return map;
        } catch (Exception e) {
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> editReceiptAddress(UserAddressParam param) {
        Map<String, Object> map = new HashMap<String, Object>();

        String phone = jedisTemplate.opsForValue().get("tyj_token:" + param.getToken());
        if (phone == null) {// token失效
            return AccountConstants.MAP_TOKEN_FAILURE;
        }

        try {
            int result = accountAddressInfoService.editReceiptAddress(param);
            if (result == 0) {
                map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50402);
                map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50402_MSG);
            } else {
                map.put(Constants.STATE, Constants.SUCCESS);
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> setDefaultReceiptAddress(UserAddressParam param) {
        Map<String, Object> map = new HashMap<String, Object>();

        String phone = jedisTemplate.opsForValue().get("tyj_token:" + param.getToken());
        if (phone == null) {// token失效
            return AccountConstants.MAP_TOKEN_FAILURE;
        }
        try {
            int result = accountAddressInfoService.setDefaultReceiptAddress(param);
            if (result == 0) {
                map.put(Constants.STATE, AccountConstants.ACCOUNT_ERROR_CODE_50402);
                map.put(Constants.ERROR_MSG, AccountConstants.ACCOUNT_ERROR_CODE_50402_MSG);
            } else {
                map.put(Constants.STATE, Constants.SUCCESS);
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }
}
