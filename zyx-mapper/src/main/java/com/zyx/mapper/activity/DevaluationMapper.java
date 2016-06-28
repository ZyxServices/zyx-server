package com.zyx.mapper.activity;

import com.zyx.entity.Devaluation;
import com.zyx.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SubDong on 16-6-28.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title DevaluationMapper
 * @package com.zyx.mapper.activity
 * @update 16-6-28 下午3:13
 */
@Repository("devaluationMapper")
public interface DevaluationMapper extends BaseMapper<Devaluation> {
    /**
     * 删除首推项
     * @param devaluation
     */
    int deleteDevaluation(Devaluation devaluation);

    /**
     * 查询首推项
     * @param types
     * @return
     */
    List<Devaluation> queryDevaluation(Integer types);
}
