package com.zyx.rpc.system;


import java.util.List;

/**
 * Created by MrDeng on 2016/8/3.
 */
public interface DevaFacade {
    /**
     *
     * @param area
     * @param model
     * @return
     */
    public List getDevaByModel(Integer area,Integer model);
    public List getAllDeva();
}
