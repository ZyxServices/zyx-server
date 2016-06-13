package com.zyx.mapper.activity;

import com.zyx.entity.activity.Activity;
import com.zyx.entity.activity.parm.QueryActivityParm;
import com.zyx.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Rainbow on 16-6-12.
 */
@Repository("activityMapper")
public interface ActivityMapper extends BaseMapper<Activity> {

    /**
     * 多条条件查询活动
     * @param parm
     * @return
     */
    List<Activity> queryActivity(QueryActivityParm parm);
}
