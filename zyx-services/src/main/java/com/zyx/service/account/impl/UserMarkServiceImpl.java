package com.zyx.service.account.impl;

import com.zyx.entity.account.UserMarkInfo;
import com.zyx.param.account.UserMarkParam;
import com.zyx.mapper.account.UserMarkMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.account.UserMarkService;
import com.zyx.vo.account.MarkInfoVo;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by WeiMinSheng on 2016/6/15.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserMarkServiceImpl.impl
 */
@Service("userMarkService")
public class UserMarkServiceImpl extends BaseServiceImpl<UserMarkInfo> implements UserMarkService {

    public UserMarkServiceImpl() {
        super(UserMarkInfo.class);
    }

    @Override
    public Map<String, Object> sign(UserMarkParam userMarkParam) {

        return null;
    }

    @Override
    public MarkInfoVo queryMarkInfo(UserMarkParam userMarkParam) throws Exception {
        UserMarkMapper userMarkMapper = (UserMarkMapper) mapper;
        return userMarkMapper.queryMarkInfo(userMarkParam);
    }

    @Override
    public int updateMarkInfo(UserMarkParam userMarkParam) {
        UserMarkMapper userMarkMapper = (UserMarkMapper) mapper;
        return userMarkMapper.updateMarkInfo(userMarkParam);
    }
}
