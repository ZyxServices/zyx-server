package com.zyx.mapper.activity;

import com.zyx.entity.activity.Activity;
import com.zyx.entity.activity.ActivityMember;
import com.zyx.entity.activity.parm.QueryMemberParm;
import com.zyx.entity.activity.vo.QueryMemberVo;
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
     * 查询报名详细信息
     *
     * @param parm
     * @return
     */
    List<QueryMemberVo> queryActivityMemberInfo(QueryMemberParm parm);

    /**
     * 发起这审核报名
     *
     * @param id
     * @return
     */
    int updateMemberByExamine(Integer id);
}
