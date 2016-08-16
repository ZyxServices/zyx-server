package com.zyx.mapper.activity;

import com.zyx.entity.activity.Combination;
import com.zyx.entity.activity.parm.QueryCombiationParm;
import com.zyx.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by Rainbow on 2016/8/16.
 */
@Repository("combinationMapper")
public interface CombinationMapper extends BaseMapper<Combination> {

    /**
     * 多条件查询
     * @param parm
     * @return
     */
    Combination queryCombiation(QueryCombiationParm parm);
}
