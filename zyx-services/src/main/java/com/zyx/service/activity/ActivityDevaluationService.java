package com.zyx.service.activity;

import java.util.List;
import java.util.Map;

import com.zyx.entity.Devaluation;
import com.zyx.entity.activity.Activity;

/**
 * Created by SubDong on 16-6-28.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title ActivityDevaluationService
 * @package com.zyx.service.activity
 * @update 16-6-28 下午3:18
 */
public interface ActivityDevaluationService {

    /**
     * 活动首推
     * @return
     */
	List<Activity> queryActivityDeva();

    /**
     * 活动首推
     * @return
     */
    Map<String, Object> insterActivityDeva(Devaluation devaluation);

    /**
     * 取消活动首推
     * @return
     */
    Map<String, Object> delActivityDeva(Devaluation devaluation);
}
