package com.zyx.rpc.account.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.account.AccountConstants;
import com.zyx.entity.account.param.UserAddressParam;
import com.zyx.rpc.account.AccountAddressFacade;
import com.zyx.service.account.AccountAddressInfoService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.account.UserAddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

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
    protected RedisTemplate<String, String> stringRedisTemplate;

    @Override
    public Map<String, Object> insertAccountAddressInfo(UserAddressParam param) {
        String phone = stringRedisTemplate.opsForValue().get("tyj_token:" + param.getToken());
        if (phone == null) {// token失效
            return Constants.MAP_TOKEN_FAILURE;
        }
        try {
            int result = accountAddressInfoService.insertAccountAddressInfo(param);
            if (result == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50400, AccountConstants.ACCOUNT_ERROR_CODE_50400_MSG);
            }
            return MapUtils.buildSuccessMap(Constants.SUCCESS, "收货地址新增成功", null);
        } catch (Exception e) {
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> queryAccountAddressInfo(UserAddressParam param) {
        String phone = stringRedisTemplate.opsForValue().get("tyj_token:" + param.getToken());
        if (phone == null) {// token失效
            return Constants.MAP_TOKEN_FAILURE;
        }
        try {
            UserAddressVo userAddressVo = accountAddressInfoService.selectAddressByAddressId(param);
            if (userAddressVo == null) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50300, AccountConstants.ACCOUNT_ERROR_CODE_50300_MSG);
            }
            return MapUtils.buildSuccessMap(Constants.SUCCESS, "收货地址查询成功", userAddressVo);
        } catch (Exception e) {
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> queryAccountAddressList(UserAddressParam param) {
        String phone = stringRedisTemplate.opsForValue().get("tyj_token:" + param.getToken());
        if (phone == null) {// token失效
            return Constants.MAP_TOKEN_FAILURE;
        }
        try {
            List<UserAddressVo> result = accountAddressInfoService.selectAddressList(param);
            if (result == null || result.size() == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50300, AccountConstants.ACCOUNT_ERROR_CODE_50300_MSG);
            }
            return MapUtils.buildSuccessMap(Constants.SUCCESS, "收货地址列表查询成功", result);
        } catch (Exception e) {
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> deleteAccountAddressInfo(UserAddressParam param) {
        String phone = stringRedisTemplate.opsForValue().get("tyj_token:" + param.getToken());
        if (phone == null) {// token失效
            return Constants.MAP_TOKEN_FAILURE;
        }
        try {
            int result = accountAddressInfoService.deleteByAddressId(param);
            if (result == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50401, AccountConstants.ACCOUNT_ERROR_CODE_50401_MSG);
            }
            return MapUtils.buildSuccessMap(Constants.SUCCESS, "收货地址删除成功", null);
        } catch (Exception e) {
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> editReceiptAddress(UserAddressParam param) {
        String phone = stringRedisTemplate.opsForValue().get("tyj_token:" + param.getToken());
        if (phone == null) {// token失效
            return Constants.MAP_TOKEN_FAILURE;
        }
        try {
            int result = accountAddressInfoService.editReceiptAddress(param);
            if (result == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50402, AccountConstants.ACCOUNT_ERROR_CODE_50402_MSG);
            }
            return MapUtils.buildSuccessMap(Constants.SUCCESS, "收货地址编辑成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> setDefaultReceiptAddress(UserAddressParam param) {
        String phone = stringRedisTemplate.opsForValue().get("tyj_token:" + param.getToken());
        if (phone == null) {// token失效
            return Constants.MAP_TOKEN_FAILURE;
        }
        try {
            int result = accountAddressInfoService.setDefaultReceiptAddress(param);
            if (result == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50402, AccountConstants.ACCOUNT_ERROR_CODE_50402_MSG);
            }
            return MapUtils.buildSuccessMap(Constants.SUCCESS, "默认收货地址设置成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return Constants.MAP_500;
        }
    }
}
