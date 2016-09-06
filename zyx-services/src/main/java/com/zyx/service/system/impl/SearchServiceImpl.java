package com.zyx.service.system.impl;

import com.zyx.constants.Constants;
import com.zyx.entity.activity.PageViews;
import com.zyx.mapper.system.SearchMapper;
import com.zyx.param.system.SearchParam;
import com.zyx.service.activity.ActivityService;
import com.zyx.service.activity.PageViwesService;
import com.zyx.service.live.LiveInfoService;
import com.zyx.service.system.SearchService;
import com.zyx.utils.MapUtils;
import com.zyx.utils.easemob.EasemobAppKey;
import com.zyx.vo.system.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Rainbow on 2016/8/23.
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private LiveInfoService liveInfoService;

    @Resource
    private PageViwesService pageViwesService;

    @Resource
    private SearchMapper searchMapper;

    @Override
    public Map<String, Object> modularSearch(SearchParam searchParam) {
        if (searchParam != null && searchParam.getModel() != null && searchParam.getPageNumber() != null && searchParam.getPages() != null) {
            if (searchParam.getCharacter() == null) searchParam.setCharacter("");
            searchParam.setPages((searchParam.getPages() - 1) * searchParam.getPageNumber());
            switch (searchParam.getModel()) {
                case 1: // 用户
                    List<SearchAccountVo> searchAccountVos = searchMapper.searchAccount(searchParam);
                    if (searchAccountVos.size() > 0) {
                        return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", searchAccountVos);
                    } else {
                        return MapUtils.buildErrorMap(Constants.NO_DATA, "查无数据");
                    }
                case 2: //圈子
                    List<SearchCirleVo> searchCirleVos = searchMapper.searchCirle(searchParam);
                    if (searchCirleVos.size() > 0) {
                        return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", searchCirleVos);
                    } else {
                        return MapUtils.buildErrorMap(Constants.NO_DATA, "查无数据");
                    }
                case 3: //活动
                    List<SearchActivityVo> searchActivityVos = searchMapper.searchActivtiy(searchParam);
                    if (searchActivityVos.size() > 0) {
                        searchActivityVos.stream().filter(e -> e.getId() != null).forEach(s -> s.setPageviews(getPageViwes(2, s.getId())));
                        return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", searchActivityVos);
                    } else {
                        return MapUtils.buildErrorMap(Constants.NO_DATA, "查无数据");
                    }
                case 4: //直播
                    List<SearchLiveVo> searchLiveVos = searchMapper.searchLive(searchParam);
                    searchLiveVos.forEach(e -> e.setNumber(liveInfoService.getLiveWatcherNumber(e.getId())));
                    if (searchLiveVos.size() > 0) {
                        searchLiveVos.stream().filter(e -> e.getId() != null).forEach(s -> s.setPageviews(getPageViwes(0, s.getId())));
                        return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", searchLiveVos);
                    } else {
                        return MapUtils.buildErrorMap(Constants.NO_DATA, "查无数据");
                    }
                case 5: //动态
                    List<SearchConcernVo> searchConcernVos = searchMapper.searchConcern(searchParam);
                    if (searchConcernVos.size() > 0) {
                        searchConcernVos.stream().filter(e -> e.getId() != null).forEach(s -> s.setPageviews(getPageViwes(1, s.getId())));
                        return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", searchConcernVos);
                    } else {
                        return MapUtils.buildErrorMap(Constants.NO_DATA, "查无数据");
                    }
                case 6: //帖子
                    List<SearchPostsVo> searchPostsVos = searchMapper.searchPosts(searchParam);
                    if (searchPostsVos.size() > 0) {
                        searchPostsVos.stream().filter(e -> e.getId() != null).forEach(s -> s.setPageviews(getPageViwes(3, s.getId())));
                        return MapUtils.buildSuccessMap(Constants.SUCCESS, "查询成功", searchPostsVos);
                    } else {
                        return MapUtils.buildErrorMap(Constants.NO_DATA, "查无数据");
                    }
            }
        } else {
            return Constants.MAP_PARAM_MISS;
        }
        return MapUtils.buildErrorMap(Constants.NO_DATA, "查无数据");
    }

    private Integer getPageViwes(int model, Integer id) {
        PageViews pageViews = pageViwesService.getPageViwesByInternal(model, id);
        return pageViews.getPageviews();
    }
}
