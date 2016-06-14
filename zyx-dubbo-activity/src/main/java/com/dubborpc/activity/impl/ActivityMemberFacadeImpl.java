package com.dubborpc.activity.impl;

import com.dubborpc.activity.ActivityMemberFacade;
import com.zyx.entity.activity.parm.AddMemberInfoParm;
import com.zyx.entity.activity.parm.QueryMemberParm;
import com.zyx.service.activity.ActivityMemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Rainbow on 16-6-14.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.dubborpc.activity.impl
 */
@Service("activityMemberFacade")
public class ActivityMemberFacadeImpl implements ActivityMemberFacade {

    @Resource
    private ActivityMemberService activityMemberService;

    @Override
    public Map<String, Object> addActivityMember(AddMemberInfoParm addMemberInfoParm) {
        return activityMemberService.addActivityMember(addMemberInfoParm);
    }

    @Override
    public Map<String, Object> queryActivityMember(QueryMemberParm queryMemberParm) {
        return activityMemberService.queryActivityMemberInfo(queryMemberParm);
    }
}
