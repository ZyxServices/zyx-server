package com.zyx.service.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.activity.ActivityConstants;
import com.zyx.entity.activity.Activity;
import com.zyx.entity.activity.ActivityMember;
import com.zyx.entity.activity.parm.MemberInfoParm;
import com.zyx.entity.activity.parm.QueryMemberParm;
import com.zyx.entity.activity.vo.QueryMemberVo;
import com.zyx.mapper.activity.ActivityMapper;
import com.zyx.mapper.activity.ActivityMemberMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.activity.ActivityMemberService;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rainbow on 16-6-14.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.zyx.service.activity.impl
 */
@Service
public class ActivityMemberServiceImpl extends BaseServiceImpl<ActivityMember> implements ActivityMemberService {

    @Resource
    private ActivityMapper activityMapper;
    @Resource
    private ActivityMemberMapper activityMemberMapper;

    public ActivityMemberServiceImpl() {
        super(ActivityMember.class);
    }


    @Override
    public Map<String, Object> addActivityMember(MemberInfoParm parm) {

        if (parm.getActivityId() != null && parm.getUserId() != null
                && parm.getMemberInfo() != null && parm.getUserNick() != null
                && parm.getPhone() != null) {

            QueryMemberParm queryMemberParm = new QueryMemberParm();
            queryMemberParm.setActivityId(parm.getActivityId());
            queryMemberParm.setUserId(parm.getUserId());

            List<QueryMemberVo> queryMemberVos = activityMemberMapper.queryActivityMemberInfo(queryMemberParm);
            if (queryMemberVos.size() > 0) {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10005, "此用户已报名过此活动");
            }

            ActivityMember activityMember = new ActivityMember();

            activityMember.setPhone(parm.getPhone());
            activityMember.setActivityId(parm.getActivityId());
            activityMember.setUserId(parm.getUserId());
            activityMember.setUserNick(parm.getUserNick());

            activityMember.setMemberInfo(parm.getMemberInfo());
            activityMember.setJoinTime(System.currentTimeMillis());
            activityMember.setCreateTime(System.currentTimeMillis());

            Activity activity = activityMapper.selectByPrimaryKey(parm.getActivityId());

            if (activity.getExamine() == 1) activityMember.setExamineType(false);
            else activityMember.setExamineType(true);


            int insert = mapper.insert(activityMember);
            if (insert > 0) {
                return MapUtils.buildSuccessMap(Constants.SUCCESS, "报名成功", null);
            } else {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10004, "报名失败");
            }
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }

    @Override
    public Map<String, Object> delActivityMember(MemberInfoParm memberInfoParm) {
        Map<String, Object> map = new HashMap<>();

        if (memberInfoParm != null && memberInfoParm.getActivityId() != null && memberInfoParm.getUserId() != null) {
            int member = activityMemberMapper.delActivityMember(memberInfoParm);
            if (member > 0) {
                return MapUtils.buildSuccessMap(Constants.SUCCESS, "取消对应报名成功", null);
            } else {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10010, "取消对应报名失败");
            }
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }

    @Override
    public Map<String, Object> queryActivityMemberInfo(QueryMemberParm parm) {
        if (parm.getActivityId() == null && parm.getUserId() == null) {
            return Constants.MAP_PARAM_MISS;
        }

        List<QueryMemberVo> queryMemberVos = activityMemberMapper.queryActivityMemberInfo(parm);

        if (queryMemberVos != null && queryMemberVos.size() > 0) {
            return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", queryMemberVos);
        } else {
            return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10002, "查无数据");
        }
    }

    @Override
    public Map<String, Object> updateMemberByExamine(Integer id) {

        if (id == null) {
            return Constants.MAP_PARAM_MISS;
        }
        int integer = activityMemberMapper.updateMemberByExamine(id);
        if (integer > 0) {
            return MapUtils.buildSuccessMap(Constants.SUCCESS, "审核成功", null);
        } else {
            return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10006, "审核失败");
        }
    }
}
