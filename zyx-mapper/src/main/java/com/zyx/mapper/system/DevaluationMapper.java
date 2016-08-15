package com.zyx.mapper.system;

import com.zyx.entity.system.Devaluation;
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
     *
     * @param devaluation
     */
    int deleteDevaluation(Devaluation devaluation);

    /**
     * 查询首推项
     *
     * @param model
     * @return
     */
    List<Devaluation> queryDevaluation(Integer model);

    /**
     * 查询相关类型的所有首推ids
     *
     * @param model
     * @return
     */
    List<Integer> queryDevaIds(Integer model);

    /**
     * 根据type和首推现id查询首推信息
     *
     * @param model
     * @param modelId
     * @return
     */
    Devaluation queryDevaluationByDevaId(Integer model, Integer modelId);
}
