package com.zyx.rpc.common.impl;

import com.zyx.manager.TokenManager;
import com.zyx.rpc.common.TokenFacade;
import com.zyx.token.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wms on 2016/7/6.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title TokenFacadeImpl.java
 */
@Service("tokenFacade")
public class TokenFacadeImpl implements TokenFacade {

    @Autowired
    private TokenManager manager;

    @Override
    public boolean preHandle(String anthorization) {
        // 验证token
        TokenModel model = manager.getToken(anthorization);
        if (manager.checkToken(model)) {
            System.out.println(model.getToken());
            return true;
        }
        return true;
    }
}
