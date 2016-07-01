package com.zyx.service.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.constants.activity.ActivityConstants;
import com.zyx.entity.activity.PageViews;
import com.zyx.mapper.activity.ActivityTopicMapper;
import com.zyx.mapper.activity.PageViewsMapper;
import com.zyx.service.activity.PageViwesService;
import com.zyx.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by SubDong on 16-6-27.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title PageViwesServiceImpl
 * @package com.zyx.service.activity.impl
 * @update 16-6-27 上午11:35
 */
@Service
public class PageViwesServiceImpl implements PageViwesService {
    //浏览量
    private static String REDIS_PAGE_VIEWS = "pageViews";

    @Resource
    protected RedisTemplate<String, String> stringRedisTemplate;

    @Resource
    private PageViewsMapper pageViewsMapper;

    @Override
    public void pageViwes(Integer types, Integer typeId) {
        String sValue = stringRedisTemplate.opsForValue().get(REDIS_PAGE_VIEWS + types);
        String newValue;
        if (sValue == null) {
            newValue = typeId + "_" + types;
            stringRedisTemplate.opsForValue().set(REDIS_PAGE_VIEWS + types, newValue);
        } else if (!sValue.contains(typeId + "_" + types)) {
            newValue = sValue + "," + typeId + "_" + types;
            stringRedisTemplate.opsForValue().set(REDIS_PAGE_VIEWS + types, newValue);
        }

        String sidValue = stringRedisTemplate.opsForValue().get(typeId + "_" + types);
        if (sidValue != null && !sidValue.equals("")) {
            int newSidValue = Integer.parseInt(sidValue) + 1;
            stringRedisTemplate.opsForValue().set(typeId + "_" + types, newSidValue + "");
        } else {
            stringRedisTemplate.opsForValue().set(typeId + "_" + types, "1");
        }
    }

    @Override
    public Map<String,Object> getPageViwes(Integer types, Integer typeId) {
        Map<String,Object> map = new HashMap<>();
        if(typeId != null && types != null){
            PageViews pageViews = new PageViews();
            pageViews.setTypes(types);
            pageViews.setTypeId(typeId);

            PageViews views = pageViewsMapper.queryPageView(pageViews);

            String sidValue = stringRedisTemplate.opsForValue().get(typeId + "_" + types);

            if (views != null) {
                views.setPageviews((views.getPageviews() == null ? 0 : views.getPageviews()) + (sidValue == null ? 0 : Integer.valueOf(sidValue)));
                return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", views);
            }else{
                return MapUtils.buildErrorMap(ActivityConstants.AUTH_ERROR_10002, "查无数据");
            }
        }else{
            return Constants.MAP_PARAM_MISS;
        }
    }

    @Override
    public PageViews getPageViwesByInternal(Integer types, Integer typeId) {

        PageViews pageViews = new PageViews();
        pageViews.setTypes(types);
        pageViews.setTypeId(typeId);

        PageViews views = pageViewsMapper.queryPageView(pageViews);

        String sidValue = stringRedisTemplate.opsForValue().get(typeId + "_" + types);

        if(views != null){
            views.setPageviews((views.getPageviews() == null ? 0 : views.getPageviews()) + (sidValue == null ? 0 : Integer.valueOf(sidValue)));
        }
        return views;
    }
}
