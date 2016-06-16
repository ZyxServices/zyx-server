package com.zyx.rpc.activity.impl;

import com.zyx.entity.activity.parm.AddTopicParm;
import com.zyx.entity.activity.parm.QueryTopicParm;
import com.zyx.rpc.activity.ActivityTopicFacade;
import com.zyx.service.activity.ActivityTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by SubDong on 16-6-16.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title ActivityTopicFacadeImpl
 * @package com.zyx.rpc.activity.impl
 * @update 16-6-16 下午4:05
 */
@Service("activityTopicFacade")
public class ActivityTopicFacadeImpl implements ActivityTopicFacade {

    @Autowired
    private ActivityTopicService activityTopicService;

    @Override
    public Map<String, Object> addActivityTopic(AddTopicParm addTopicParm) {
        return activityTopicService.addActivityTopic(addTopicParm);
    }

    @Override
    public Map<String, Object> dynamicQuery(QueryTopicParm topicParm) {
        return activityTopicService.dynamicQuery(topicParm);
    }
}
