package com.zyx.rpc.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.rpc.activity.ActivityMemberFacade;
import com.zyx.entity.activity.parm.MemberInfoParm;
import com.zyx.entity.activity.parm.QueryMemberParm;
import com.zyx.rpc.activity.utils.ActivityUtils;
import com.zyx.service.activity.ActivityMemberService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rainbow on 16-6-14.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.rpc.activity.impl
 */
@Service("activityMemberFacade")
public class ActivityMemberFacadeImpl implements ActivityMemberFacade {

    @Resource
    private ActivityMemberService activityMemberService;

    private static Logger logger = Logger.getLogger(ActivityMemberFacadeImpl.class);

    @Override
    public Map<String, Object> addActivityMember(MemberInfoParm addMemberInfoParm) {
        try {
            return activityMemberService.addActivityMember(addMemberInfoParm);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return ActivityUtils.Error500();
        }
    }

    @Override
    public Map<String, Object> delActivityMember(MemberInfoParm memberInfoParm) {
        try{
            return activityMemberService.delActivityMember(memberInfoParm);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
            return ActivityUtils.Error500();
        }
    }

    @Override
    public Map<String, Object> queryActivityMember(QueryMemberParm queryMemberParm) {
        try {
            return activityMemberService.queryActivityMemberInfo(queryMemberParm);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return ActivityUtils.Error500();
        }
    }

    @Override
    public Map<String, Object> updateMemberByExamine(Integer id) {
        try {
            return activityMemberService.updateMemberByExamine(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return ActivityUtils.Error500();
        }
    }
}
