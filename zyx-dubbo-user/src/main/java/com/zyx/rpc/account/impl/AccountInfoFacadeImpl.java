package com.zyx.rpc.account.impl;

import com.zyx.constants.account.AccountConstants;
import com.zyx.entity.account.UserLoginParam;
import com.zyx.entity.account.param.AccountInfoParam;
import com.zyx.rpc.account.AccountInfoFacade;
import com.zyx.rpc.common.TokenFacade;
import com.zyx.service.account.AccountInfoService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.account.AccountInfoVo;
import com.zyx.vo.account.MyCenterInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private TokenFacade tokenFacade;

    @Override
    public Map<String, Object> queryAccountInfo(String token, int userId) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(token, userId);
            if (map != null) {
                return map;
            }
            UserLoginParam userLoginParam = new UserLoginParam();
            userLoginParam.setToken(token);
            userLoginParam.setId(userId);
            List<AccountInfoVo> list = accountInfoService.selectAccountByParam(userLoginParam);
            if (list == null || list.size() == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50300, AccountConstants.ACCOUNT_ERROR_CODE_50300_MSG);
            } else {
                return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "用户信息查询成功", list.get(0));
            }
        } catch (Exception e) {
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> editAccountInfo(String token, int userId, AccountInfoParam param) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(token, userId);
            if (map != null) {
                return map;
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
            Map<String, Object> map = tokenFacade.validateTokenIncludeOther(token, userId);
            if (map != null) {
                return map;
            }
            UserLoginParam userLoginParam = new UserLoginParam();
            userLoginParam.setId(userId);
            MyCenterInfoVo _info = accountInfoService.queryMyCenterInfo(userLoginParam);
            if (_info == null) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50300, AccountConstants.ACCOUNT_ERROR_CODE_50300_MSG);
            } else {
                return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "用户信息查询成功", _info);
            }
        } catch (Exception e) {
            return AccountConstants.MAP_500;
        }
    }

}
