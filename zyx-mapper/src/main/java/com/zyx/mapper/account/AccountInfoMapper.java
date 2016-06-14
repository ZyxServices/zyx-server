package com.zyx.mapper.account;

import com.zyx.entity.account.AccountInfo;
import com.zyx.entity.account.UserLoginParam;
import com.zyx.mapper.BaseMapper;

import java.util.List;

/**
 * Created by WeiMinSheng on 2016/6/13.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AccountInfoMapper.java
 */
public interface AccountInfoMapper extends BaseMapper<AccountInfo> {
    int selectAccountByPhone(String phone);

    List<AccountInfo> selectAccountByParam(UserLoginParam userLoginParam);

    int renewpwd(UserLoginParam userLoginParam);
}
