package com.zyx.rpc.activity;

import java.util.Map;

/**
 * Created by SubDong on 16-6-27.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title PageViwesFacade
 * @package com.zyx.rpc.activity.main
 * @update 16-6-27 上午11:32
 */
public interface PageViwesFacade {
    /**
     * 浏览量
     *
     * @param types
     * @param typeId
     * @return
     */
    void pageViwes(Integer types, Integer typeId);

    /**
     * 获取浏览量
     *
     * @param types
     * @param typeId
     * @return
     */
    Map<String, Object> getPageViwes(Integer types, Integer typeId);
}
