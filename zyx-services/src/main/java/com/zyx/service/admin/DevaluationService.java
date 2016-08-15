package com.zyx.service.admin;

import com.zyx.entity.system.Devaluation;
import com.zyx.service.BaseService;

import java.util.List;

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
