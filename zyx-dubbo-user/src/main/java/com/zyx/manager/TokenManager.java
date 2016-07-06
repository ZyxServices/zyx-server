package com.zyx.manager;

import com.zyx.token.TokenModel;

/**
 * Created by wms on 2016/7/6.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title TokenManager.java
 */
public interface TokenManager {
    /**
     * 创建一个token关联上指定用户
     *
     * @param phone 指定用户的手机号码
     * @return 生成的token
     */
    TokenModel createToken(String phone);

    /**
     * 从字符串中解析token
     *
     * @param authentication 加密后的字符串
     * @return
     */
    TokenModel getToken(String authentication);

    /**
     * 检查token是否有效
     *
     * @param model token
     * @return 是否有效
     */
    boolean checkToken(TokenModel model);

    /**
     * 清除token
     *
     * @param phone 指定用户的手机号码
     */
    void deleteToken(String phone);
}
