package com.zyx.service.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.activity.ActivityConstants;
import com.zyx.entity.activity.ActivityTopic;
import com.zyx.entity.activity.parm.AddTopicParm;
import com.zyx.entity.activity.parm.QueryTopicParm;
import com.zyx.mapper.activity.ActivityTopicMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.activity.ActivityTopicService;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
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

    @Resource
    private ActivityTopicMapper activityTopicMapper;

    public ActivityTopicSerivceImpl() {
        super(ActivityTopic.class);
    }


    @Override
    public Map<String, Object> addActivityTopic(AddTopicParm parm) {
        if (parm == null) {
            return Constants.MAP_PARAM_MISS;
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
            if (insert > 0) {
                return MapUtils.buildSuccessMap(Constants.SUCCESS, "发布活动动态成功", null);
            } else {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10008, "发布动态失败");
            }
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }

    @Override
    public Map<String, Object> dynamicQuery(QueryTopicParm topicParm) {

        if (topicParm != null && topicParm.getActivityId() != null) {
            if (topicParm.getPageNumber() == 0) {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10003, "分页参数无效");
            }
            topicParm.setPages((topicParm.getPages() - 1) * topicParm.getPageNumber());
            List<ActivityTopic> topics = activityTopicMapper.dynamicQuery(topicParm);
            if (topics != null && topics.size() > 0) {
                Map<String, Object> objectMap = new HashMap<>();
                topics.forEach(e -> {
                    objectMap.put("id", e.getId());
                    objectMap.put("userId", e.getUserId());
                    objectMap.put("activityId", e.getActivityId());
                    objectMap.put("topicTitle", e.getTopicTitle());
                    objectMap.put("topicContent", e.getTopicContent());
                    objectMap.put("topicDate", e.getTopicDate());
                    String[] strings = e.getImages().split(",");
                    objectMap.put("images", strings);
                });
                return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", objectMap);
            } else {
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10002, "查无数据");
            }
        } else {
            return Constants.MAP_PARAM_MISS;
        }
    }
}
