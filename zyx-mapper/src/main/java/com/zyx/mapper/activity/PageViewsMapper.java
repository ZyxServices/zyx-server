package com.zyx.mapper.activity;

import com.zyx.entity.activity.PageViews;
import com.zyx.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by SubDong on 16-6-27.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title PageViewsMapper
 * @package com.zyx.mapper.activity
 * @update 16-6-27 下午3:52
 */
@Repository("pageViewsMapper")
public interface PageViewsMapper extends BaseMapper<PageViews> {

    /**
     * 查询浏览量
     * @param pageViews
     * @return
     */
    PageViews queryPageView(PageViews pageViews);
}
