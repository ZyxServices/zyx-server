package com.zyx.service.activity;

import com.zyx.entity.activity.ActivityMember;
import com.zyx.param.activity.MemberInfoParm;
import com.zyx.param.activity.QueryMemberParm;
import com.zyx.service.BaseService;

import java.util.Map;

/**
 * Created by Rainbow on 16-6-14.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.zyx.service.activity
 */
public interface ActivityMemberService extends BaseService<ActivityMember> {

    /**
     * 活动报名信息添加
     *
     * @param addMemberInfoParm
     * @return
     */
    Map<String, Object> addActivityMember(MemberInfoParm addMemberInfoParm);

    /**
     * 取消对应活动的报名
     *
     * @param memberInfoParm
     * @return
     */
    Map<String, Object> delActivityMember(MemberInfoParm memberInfoParm);

    /**
     * 查询报名信息添加
     *
     * @param queryMemberParm
     * @return
     */
    Map<String, Object> queryActivityMemberInfo(QueryMemberParm queryMemberParm);

    /**
     * 发起这审核报名
     *
     * @param id
     * @return
     */
    Map<String, Object> updateMemberByExamine(Integer id);
}
