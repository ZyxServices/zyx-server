package com.zyx.service.account.impl;

import com.zyx.entity.account.AccountInfo;
import com.zyx.entity.account.UserLoginParam;
import com.zyx.mapper.account.AccountInfoMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.account.AccountInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WeiMinSheng on 2016/6/13.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AccountInfoServiceImpl.java
 */
@Service("accountInfoService")
public class AccountInfoServiceImpl extends BaseServiceImpl<AccountInfo> implements AccountInfoService {

    @Override
    public int selectAccountByPhone(String phone) {
        AccountInfoMapper accountInfoMapper = (AccountInfoMapper) mapper;
        return accountInfoMapper.selectAccountByPhone(phone);
    }

    @Override
    public List<AccountInfo> selectAccountByParam(UserLoginParam userLoginParam) {
        AccountInfoMapper accountInfoMapper = (AccountInfoMapper) mapper;
        return accountInfoMapper.selectAccountByParam(userLoginParam);
    }

    @Override
    public int renewpwd(UserLoginParam userLoginParam) {
        AccountInfoMapper accountInfoMapper = (AccountInfoMapper) mapper;
        return accountInfoMapper.renewpwd(userLoginParam);
    }
}
