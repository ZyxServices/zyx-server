package com.zyx.mapper.activity;

import com.zyx.entity.activity.ActivityMember;
import com.zyx.param.activity.MemberInfoParm;
import com.zyx.param.activity.QueryMemberParm;
import com.zyx.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Rainbow on 16-6-14.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.zyx.mapper.activity
 */
@Repository("activityMemberMapper")
public interface ActivityMemberMapper extends BaseMapper<ActivityMember> {

    /**
     * 取消对应活动的报名
     *
     * @param memberInfoParm
     * @return
     */
    int delActivityMember(MemberInfoParm memberInfoParm);

    /**
     * 查询报名详细信息
     *
     * @param parm
     * @return
     */
    List<ActivityMember> queryActivityMemberInfo(QueryMemberParm parm);

    /**
     * 发起者批量审核报名
     *
     * @param stringObjectMap
     * @return
     */
    int updateMemberByExamine(Map<String, Object> stringObjectMap);
}
