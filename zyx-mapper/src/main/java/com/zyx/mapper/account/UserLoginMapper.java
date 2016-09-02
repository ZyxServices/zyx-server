package com.zyx.mapper.account;

import com.zyx.entity.account.UserLoginInfo;
import com.zyx.param.account.UserLoginParam;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.account.AccountInfoVo;

/**
 * Created by WeiMinSheng on 2016/6/13.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserLoginMapper.java
 */
public interface UserLoginMapper extends BaseMapper<UserLoginInfo> {

    AccountInfoVo loginByPhoneAndPassword(UserLoginParam userLoginParam);

}
