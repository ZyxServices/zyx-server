package com.zyx.service.account;

import com.zyx.entity.account.UserLoginInfo;
import com.zyx.service.BaseService;
import com.zyx.vo.account.AccountInfoVo;

/**
 * Created by skmbg on 2016/6/12.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.zyx.service.account
 */
public interface UserLoginService extends BaseService<UserLoginInfo> {
    AccountInfoVo loginByPhoneAndPassword(String phone, String password);
}
