package com.zyx.mapper.activity;

import com.zyx.entity.activity.ActivityMember;
import com.zyx.entity.activity.ActivityTopic;
import com.zyx.entity.activity.parm.QueryMemberParm;
import com.zyx.entity.activity.vo.QueryMemberVo;
import com.zyx.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rainbow on 16-6-14.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.zyx.mapper.activity
 */
@Repository("activityTopicMapper")
public interface ActivityTopicMapper extends BaseMapper<ActivityTopic> {

}
