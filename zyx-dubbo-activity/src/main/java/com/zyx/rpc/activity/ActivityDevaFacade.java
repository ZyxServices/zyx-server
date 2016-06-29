package com.zyx.rpc.activity;

import com.zyx.entity.Devaluation;
import com.zyx.entity.activity.Activity;

import java.util.List;
import java.util.Map;

/**
 * Created by SubDong on 16-6-28.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title ActivityDevaFacadel
 * @package com.zyx.rpc.activity
 * @update 16-6-28 下午3:35
 */
public interface ActivityDevaFacade {

    /**
     * 活动首推查询
     *
     * @return
     */
    Map<String, Object> queryActivityDeva();

    /**
     * 活动首推
     *
     * @return
     */
    Map<String, Object> insterActivityDeva(Devaluation devaluation);

    /**
     * 取消活动首推
     *
     * @return
     */
    Map<String, Object> delActivityDeva(Devaluation devaluation);

    /**
     * 获取redis中到活动首推
     *
     * @return
     */
    List<Activity> getActivityDeva();
}
