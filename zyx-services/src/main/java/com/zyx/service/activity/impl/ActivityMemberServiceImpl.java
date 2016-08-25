package com.zyx.service.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.activity.ActivityConstants;
import com.zyx.entity.activity.Activity;
import com.zyx.entity.activity.ActivityMember;
import com.zyx.entity.activity.parm.MemberInfoParm;
import com.zyx.entity.activity.parm.QueryMemberParm;
import com.zyx.vo.activity.QueryMemberVo;
import com.zyx.mapper.account.AccountInfoMapper;
import com.zyx.mapper.activity.ActivityMapper;
import com.zyx.mapper.activity.ActivityMemberMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.activity.ActivityMemberService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.account.QueryUserInfoVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    @Resource
    private AccountInfoMapper accountInfoMapper;

    public ActivityMemberServiceImpl() {
        super(ActivityMember.class);
    }


    @Override
    public Map<String, Object> addActivityMember(MemberInfoParm parm) {

        if (parm.getActivityId() != null && parm.getUserId() != null && parm.getUserNick() != null
                && parm.getPhone() != null) {

            QueryMemberParm queryMemberParm = new QueryMemberParm();
            queryMemberParm.setActivityId(parm.getActivityId());
            queryMemberParm.setUserId(parm.getUserId());

            List<ActivityMember> queryMemberVos = activityMemberMapper.queryActivityMemberInfo(queryMemberParm);
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
            activity.setMask(0);

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

        List<ActivityMember> queryMemberVos = activityMemberMapper.queryActivityMemberInfo(parm);
        List<QueryMemberVo> memberVos = new ArrayList<>();
        queryMemberVos.forEach(e -> {
            QueryUserInfoVo queryUserInfoVo = accountInfoMapper.selectAccountById(e.getUserId());
            QueryMemberVo queryMemberVo = new QueryMemberVo();
            queryMemberVo.setId(e.getId());
            queryMemberVo.setActivityId(e.getActivityId());
            queryMemberVo.setJoinTime(e.getJoinTime());
            queryMemberVo.setExamineType(e.isExamineType());
            queryMemberVo.setMemberInfo(e.getMemberInfo());
            queryMemberVo.setPhone(e.getPhone());
            queryMemberVo.setUserId(e.getUserId());
            queryMemberVo.setSex(queryUserInfoVo.getSex() == null ? 1 : queryUserInfoVo.getSex());
            queryMemberVo.setUserNick(queryUserInfoVo.getNickname());
            queryMemberVo.setBirthday(queryUserInfoVo.getBirthday() == null ? 0 : ((System.currentTimeMillis() - queryUserInfoVo.getBirthday()) / (365 * 24 * 60 * 60 * 1000l)));
            queryMemberVo.setMask(e.getMask() == null ? 0 : e.getMask());
            memberVos.add(queryMemberVo);
        });

        if (memberVos.size() > 0) {
            return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", memberVos);
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
