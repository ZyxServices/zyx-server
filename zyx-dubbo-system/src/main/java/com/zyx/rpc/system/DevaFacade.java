package com.zyx.rpc.system;

import com.zyx.entity.deva.dto.DevaDto;

import java.util.List;

/**
 * Created by MrDeng on 2016/8/3.
 */
public interface DevaFacade {
    /**
     *
     * @param model
     * @return
     */
    public List getDevaByModel(Integer model);
    public List getAllDeva();
//    public void refreshDevaByModel(Integer model);
//    public void refreshAllDeva();
}
