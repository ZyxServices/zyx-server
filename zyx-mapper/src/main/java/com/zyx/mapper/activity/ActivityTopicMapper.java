package com.zyx.mapper.activity;

import com.zyx.entity.activity.ActivityTopic;
import com.zyx.param.activity.QueryTopicParm;
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

    /**
     * 查询对应活动下到动态信息
     *
     * @param topicParm
     * @return
     */
    List<ActivityTopic> dynamicQuery(QueryTopicParm topicParm);

}
