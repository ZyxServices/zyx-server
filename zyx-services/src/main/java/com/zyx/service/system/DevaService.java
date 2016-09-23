package com.zyx.service.system;

import com.zyx.entity.system.Devaluation;
import com.zyx.param.system.DevaParam;
import com.zyx.service.BaseService;

import java.util.List;

public interface DevaService extends BaseService<Devaluation>{
	/**
     * 删除首推项
     * @param devaluation
     */
    int deleteDevaluation(Devaluation devaluation);

    /**
     * 查询首推项
     * @return
     */
    List<Devaluation> selectDevas(Integer area,Integer model);
    List<Integer> selectModelIds(Integer area,Integer model);

    List selectDevasByAreaModel(Integer area,Integer model);
}
