package com.zyx.rpc.account.impl;

import com.zyx.constants.account.AccountConstants;
import com.zyx.param.account.UserAddressParam;
import com.zyx.rpc.account.AccountAddressFacade;
import com.zyx.rpc.common.TokenFacade;
import com.zyx.service.account.AccountAddressInfoService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.account.UserAddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wms on 2016/6/21.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 */
@Service("accountAddressFacade")
public class AccountAddressFacadeImpl implements AccountAddressFacade {

    @Autowired
    private AccountAddressInfoService accountAddressInfoService;

    @Autowired
    private TokenFacade tokenFacade;

    @Override
    public Map<String, Object> insertAccountAddressInfo(UserAddressParam param) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(param.getToken(), param.getUserId());
            if (map != null) {
                return map;
            }
            int result = accountAddressInfoService.insertAccountAddressInfo(param);
            if (result == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50400, AccountConstants.ACCOUNT_ERROR_CODE_50400_MSG);
            }
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "收货地址新增成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> queryAccountAddressInfo(UserAddressParam param) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(param.getToken());
            if (map != null) {
                return map;
            }
            UserAddressVo userAddressVo = accountAddressInfoService.selectAddressByAddressId(param);
            if (userAddressVo == null) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50300, AccountConstants.ACCOUNT_ERROR_CODE_50300_MSG);
            }
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "收货地址查询成功", userAddressVo);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> queryAccountAddressList(UserAddressParam param) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(param.getToken(), param.getUserId());
            if (map != null) {
                return map;
            }
            List<UserAddressVo> result = accountAddressInfoService.selectAddressList(param);
            if (result == null || result.size() == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50300, AccountConstants.ACCOUNT_ERROR_CODE_50300_MSG);
            }
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "收货地址列表查询成功", result);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> deleteAccountAddressInfo(UserAddressParam param) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(param.getToken());
            if (map != null) {
                return map;
            }
            int result = accountAddressInfoService.deleteByAddressId(param);
            if (result == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50401, AccountConstants.ACCOUNT_ERROR_CODE_50401_MSG);
            }
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "收货地址删除成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> editReceiptAddress(UserAddressParam param) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(param.getToken(), param.getUserId());
            if (map != null) {
                return map;
            }
            int result = accountAddressInfoService.editReceiptAddress(param);
            if (result == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50402, AccountConstants.ACCOUNT_ERROR_CODE_50402_MSG);
            }
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "收货地址编辑成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> setDefaultReceiptAddress(UserAddressParam param) {
        try {
            // 判断token是否失效
            Map<String, Object> map = tokenFacade.validateToken(param.getToken(), param.getUserId());
            if (map != null) {
                return map;
            }
            int result = accountAddressInfoService.setDefaultReceiptAddress(param);
            if (result == 0) {
                return MapUtils.buildErrorMap(AccountConstants.ACCOUNT_ERROR_CODE_50402, AccountConstants.ACCOUNT_ERROR_CODE_50402_MSG);
            }
            return MapUtils.buildSuccessMap(AccountConstants.SUCCESS, "默认收货地址设置成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            return AccountConstants.MAP_500;
        }
    }
}
