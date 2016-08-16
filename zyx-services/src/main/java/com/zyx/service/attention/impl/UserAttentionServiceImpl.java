package com.zyx.service.attention.impl;

import com.zyx.entity.attention.UserAttention;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.attention.UserAttentionService;
import org.springframework.stereotype.Service;

/**
 * Created by wms on 2016/8/16.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title UserAttentionServiceImpl.java
 */
@Service("userAttentionService")
public class UserAttentionServiceImpl extends BaseServiceImpl<UserAttention> implements UserAttentionService {

    public UserAttentionServiceImpl() {
        super(UserAttention.class);
    }
}
