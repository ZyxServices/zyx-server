package com.zyx.service.activity;

import com.zyx.entity.activity.PageViews;

import java.util.Map;

/**
 * Created by SubDong on 16-6-27.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title PageViwesService
 * @package com.zyx.service.activity
 * @update 16-6-27 上午11:35
 */
public interface PageViwesService {
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
    Map<String,Object> getPageViwes(Integer types, Integer typeId);

    /**
     * 获取浏览量(内部调用)
     *
     * @param types
     * @param typeId
     * @return
     */
    PageViews getPageViwesByInternal(Integer types, Integer typeId);
}
