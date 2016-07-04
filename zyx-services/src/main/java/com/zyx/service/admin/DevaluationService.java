package com.zyx.service.admin;

import java.util.List;

import com.zyx.entity.Devaluation;
import com.zyx.service.BaseService;

public interface DevaluationService extends BaseService<Devaluation>{
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
    
    List<Integer> queryDevaIds(Integer types);
}
