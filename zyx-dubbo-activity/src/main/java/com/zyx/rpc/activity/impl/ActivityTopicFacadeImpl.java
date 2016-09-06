package com.zyx.rpc.activity.impl;

import com.zyx.param.activity.AddTopicParm;
import com.zyx.param.activity.QueryTopicParm;
import com.zyx.rpc.activity.ActivityTopicFacade;
import com.zyx.rpc.activity.utils.ActivityUtils;
import com.zyx.service.activity.ActivityTopicService;
import org.apache.log4j.Logger;
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

    private static Logger logger = Logger.getLogger(ActivityTopicFacadeImpl.class);

    @Override
    public Map<String, Object> addActivityTopic(AddTopicParm addTopicParm) {
        try {
            return activityTopicService.addActivityTopic(addTopicParm);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return ActivityUtils.Error500();
        }
    }

    @Override
    public Map<String, Object> dynamicQuery(QueryTopicParm topicParm) {
        try {
            return activityTopicService.dynamicQuery(topicParm);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
            return ActivityUtils.Error500();
        }
    }
}
