package com.zyx.entity.activity.parm;

import java.io.Serializable;

/**
 * Created by SubDong on 16-6-14.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title QueryMemberParm
 * @package com.zyx.entity.activity.parm
 * @update 16-6-14 下午5:01
 */
public class QueryMemberParm implements Serializable {

    private Integer activityId;

    private Integer userId;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
