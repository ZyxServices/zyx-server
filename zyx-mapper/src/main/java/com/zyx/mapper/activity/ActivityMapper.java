package com.zyx.mapper.activity;

import com.zyx.entity.activity.Activity;
import com.zyx.param.activity.QueryActivityParm;
import com.zyx.param.activity.QueryHistoryParm;
import com.zyx.vo.activity.ActivityVo;
import com.zyx.vo.activity.MemberTemplate;
import com.zyx.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rainbow on 16-6-12.
 */
@Repository("activityMapper")
public interface ActivityMapper extends BaseMapper<Activity> {

    /**
     * 多条条件查询活动
     *
     * @param parm
     * @return
     */
    List<ActivityVo> queryActivity(QueryActivityParm parm);

    /**
     * 查询活动发起者自定义报名模板
     *
     * @param id
     * @return
     */
    MemberTemplate queryActivityMember(Integer id);

    /**
     * 1  查询历史活动
     * 2  时间范围查询活动
     *
     * @param history
     * @return
     */
    List<ActivityVo> queryActivityHistory(QueryHistoryParm history);
}
