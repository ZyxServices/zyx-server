package com.zyx.service.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.activity.ActivityConstants;
import com.zyx.entity.activity.ActivityTopic;
import com.zyx.entity.activity.parm.AddTopicParm;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.activity.ActivityTopicService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SubDong on 16-6-16.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title ActivityTopicSerivceImpl
 * @package com.zyx.service.activity.impl
 * @update 16-6-16 下午4:06
 */
@Service("activityTopicService")
public class ActivityTopicSerivceImpl extends BaseServiceImpl<ActivityTopic> implements ActivityTopicService {
    @Override
    public Map<String, Object> addActivityTopic(AddTopicParm parm) {
        Map<String, Object> map = new HashMap<>();
        if (parm == null) {
            map.put(Constants.STATE, Constants.PARAM_MISS);
            map.put(Constants.ERROR_MSG, "参数缺失");
            return map;
        }

        if (parm.getUserId() != null && parm.getActivityId() != null
                && parm.getTopicTitle() != null && parm.getTopicContent() != null) {
            ActivityTopic topic = new ActivityTopic();
            topic.setUserId(parm.getUserId());
            topic.setActivityId(parm.getActivityId());
            topic.setTopicTitle(parm.getTopicTitle());
            topic.setTopicContent(parm.getTopicContent());
            topic.setImages(parm.getImages());
            topic.setType(3);
            topic.setTopicDate(System.currentTimeMillis());
            topic.setCreateTime(System.currentTimeMillis());
            int insert = mapper.insert(topic);
            if(insert > 0){
                map.put(Constants.STATE, Constants.SUCCESS);
                map.put(Constants.SUCCESS_MSG, "发布活动动态成功");
                return map;
            }else{
                map.put(Constants.STATE, ActivityConstants.AUTH_ERROR_10008);
                map.put(Constants.ERROR_MSG, "发布动态失败");
                return map;
            }
        }else{
            map.put(Constants.STATE, Constants.PARAM_MISS);
            map.put(Constants.ERROR_MSG, "参数缺失");
            return map;
        }
    }
}
