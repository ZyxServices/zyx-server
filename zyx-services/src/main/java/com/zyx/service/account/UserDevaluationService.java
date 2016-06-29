package com.zyx.service.account;

import com.zyx.entity.Devaluation;

import java.util.Map;

/**
 * Created by skmbg on 2016/6/29.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserDevaluationService.java
 */
public interface UserDevaluationService {
    /**
     * 用户首推查询
     *
     * @return
     */
    Map<String, Object> queryUserDeva();

    /**
     * 用户首推
     *
     * @return
     */
    Map<String, Object> insertUserDeva(Devaluation devaluation);

}
