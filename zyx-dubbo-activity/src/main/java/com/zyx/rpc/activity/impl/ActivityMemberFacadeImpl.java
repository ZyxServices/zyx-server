package com.zyx.rpc.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.rpc.activity.ActivityMemberFacade;
import com.zyx.entity.activity.parm.AddMemberInfoParm;
import com.zyx.entity.activity.parm.QueryMemberParm;
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

    private static Logger loggers = Logger.getLogger(ActivityMemberFacadeImpl.class);

    @Override
    public Map<String, Object> addActivityMember(AddMemberInfoParm addMemberInfoParm) {
        try {
            return activityMemberService.addActivityMember(addMemberInfoParm);
        } catch (Exception e) {
            loggers.error(e);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(Constants.STATE, Constants.ERROR_500);
            map.put(Constants.ERROR_MSG, Constants.MSG_ERROR);
            return map;
        }
    }

    @Override
    public Map<String, Object> queryActivityMember(QueryMemberParm queryMemberParm) {
        try {
            return activityMemberService.queryActivityMemberInfo(queryMemberParm);
        } catch (Exception e) {
            loggers.error(e);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(Constants.STATE, Constants.ERROR_500);
            map.put(Constants.ERROR_MSG, Constants.MSG_ERROR);
            return map;
        }
    }

    @Override
    public Map<String, Object> updateMemberByExamine(Integer id) {
        try {
            return activityMemberService.updateMemberByExamine(id);
        } catch (Exception e) {
            loggers.error(e);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(Constants.STATE, Constants.ERROR_500);
            map.put(Constants.ERROR_MSG, Constants.MSG_ERROR);
            return map;
        }
    }
}
