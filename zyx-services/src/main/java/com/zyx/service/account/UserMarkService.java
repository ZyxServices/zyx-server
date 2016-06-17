package com.zyx.service.account;

import com.zyx.entity.account.UserMarkInfo;
import com.zyx.entity.account.param.UserMarkParam;
import com.zyx.service.BaseService;
import com.zyx.vo.account.MarkInfoVo;

import java.util.Map;

/**
 * Created by WeiMinSheng on 2016/6/15.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserMarkService.java
 */
public interface UserMarkService extends BaseService<UserMarkInfo> {
    Map<String, Object> sign(UserMarkParam userMarkParam);

    MarkInfoVo queryMarkInfo(UserMarkParam userMarkParam) throws Exception;

    int updateMarkInfo(UserMarkParam userMarkParam);
}
