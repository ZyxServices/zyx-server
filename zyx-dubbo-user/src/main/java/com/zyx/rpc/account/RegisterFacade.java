package com.zyx.rpc.account;

import com.zyx.param.account.UserLoginParam;

import java.util.Map;

/**
 * Created by wms on 2016/6/12.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 */
public interface RegisterFacade {

    /**
     * 验证手机验证码
     *
     * @param userLoginParam
     * @return
     */
    Map<String, Object> validatePhoneCode(UserLoginParam userLoginParam);

    /**
     * 注册
     *
     * @param userLoginParam
     * @return
     */
    Map<String, Object> registerAccount(UserLoginParam userLoginParam);

    /**
     * 更新密码
     *
     * @param userLoginParam
     * @return
     */
    Map<String, Object> renewpwd(UserLoginParam userLoginParam);

    /**
     * 忘记密码
     *
     * @param userLoginParam
     * @return
     */
    Map<String, Object> retrievepwd(UserLoginParam userLoginParam);

}
