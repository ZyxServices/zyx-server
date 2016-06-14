package com.zyx.service.account;

import com.zyx.entity.account.AccountInfo;
import com.zyx.entity.account.UserLoginParam;
import com.zyx.service.BaseService;

import java.util.List;

/**
 * Created by WeiMinSheng on 2016/6/13.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AccountInfoService.java
 */
public interface AccountInfoService extends BaseService<AccountInfo> {
    /**
     * 通过手机号码查询用户数量
     *
     * @param phone
     * @return
     */
    int selectAccountByPhone(String phone);

    /**
     * 通过参数查询用户列表
     *
     * @param userLoginParam
     * @return
     */
    List<AccountInfo> selectAccountByParam(UserLoginParam userLoginParam);


    /**
     * 修改密码
     *
     * @param userLoginParam
     * @return
     */
    int renewpwd(UserLoginParam userLoginParam);
}
