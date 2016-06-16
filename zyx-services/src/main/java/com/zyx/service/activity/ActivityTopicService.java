package com.zyx.service.activity;

import com.zyx.entity.activity.ActivityTopic;
import com.zyx.entity.activity.parm.AddTopicParm;
import com.zyx.service.BaseService;

import java.util.Map;

/**
 * Created by SubDong on 16-6-16.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title ActivityTopicFacade
 * @package com.zyx.rpc.activity
 * @update 16-6-16 下午2:32
 */
public interface ActivityTopicService extends BaseService<ActivityTopic> {

    /**
     * 查询报名信息添加
     * @param addTopicParm
     * @return
     */
    Map<String, Object> addActivityTopic(AddTopicParm addTopicParm);

}
