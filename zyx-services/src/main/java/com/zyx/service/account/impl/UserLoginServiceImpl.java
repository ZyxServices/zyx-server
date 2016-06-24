package com.zyx.service.account.impl;

import com.zyx.entity.account.UserLoginInfo;
import com.zyx.entity.account.UserLoginParam;
import com.zyx.mapper.account.UserLoginMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.account.UserLoginService;
import com.zyx.utils.CipherUtil;
import com.zyx.vo.account.AccountInfoVo;
import org.springframework.stereotype.Service;

/**
 * Created by WeiMinSheng on 2016/6/12.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserLoginServiceImpl.java
 */
@Service("userLoginService")
public class UserLoginServiceImpl extends BaseServiceImpl<UserLoginInfo> implements UserLoginService {

    @Override
    public AccountInfoVo loginByPhoneAndPassword(String phone, String password) {
        UserLoginParam userLoginParam = new UserLoginParam();
        userLoginParam.setPhone(phone);
        userLoginParam.setPassword(password);
        UserLoginMapper userLoginMapper = (UserLoginMapper) mapper;
        return userLoginMapper.loginByPhoneAndPassword(userLoginParam);
    }

}
