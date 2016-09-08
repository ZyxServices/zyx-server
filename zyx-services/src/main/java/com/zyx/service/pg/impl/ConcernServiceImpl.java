package com.zyx.service.pg.impl;


import com.zyx.constants.Constants;
import com.zyx.constants.pg.PgConstants;
import com.zyx.entity.activity.Activity;
import com.zyx.entity.activity.PageViews;
import com.zyx.entity.attention.UserAttention;
import com.zyx.entity.live.LiveInfo;
import com.zyx.entity.pg.CircleItem;
import com.zyx.mapper.attention.UserAttentionMapper;
import com.zyx.mapper.collection.CollectionMapper;
import com.zyx.param.attention.AttentionParam;
import com.zyx.param.collection.CollectionParam;
import com.zyx.service.activity.PageViwesService;
import com.zyx.service.attention.UserAttentionService;
import com.zyx.vo.account.AccountAttentionVo;
import com.zyx.vo.attention.AttentionVo;
import com.zyx.vo.collection.CollectionVo;
import com.zyx.vo.pg.MyFollowVo;
import com.zyx.entity.pg.Concern;
import com.zyx.mapper.pg.ConcernMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.pg.ConcernService;
import com.zyx.utils.MapUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by XiaoWei on 2016/6/7.
 */
@Service
public class ConcernServiceImpl extends BaseServiceImpl<Concern> implements ConcernService {

    @Resource
    private ConcernMapper concernMapper;

    @Resource
    private CollectionMapper collectionMapper;

    @Resource
    private PageViwesService pageViwesService;

    public ConcernServiceImpl() {
        super(Concern.class);
    }


    @Override
    public Map<String, Object> addCern(Integer userId, Integer type, String cernTitle, String content, String cernImgurl, String videoUrl, Integer visible) {
        Concern insertCern = new Concern();
        insertCern.setCreateTime(new Date().getTime());
        Optional.ofNullable(userId).ifPresent(insertCern::setUserId);
        Optional.ofNullable(type).ifPresent(insertCern::setType);
        Optional.ofNullable(cernTitle).ifPresent(insertCern::setTopicTitle);
        Optional.ofNullable(content).ifPresent(insertCern::setTopicContent);
        Optional.ofNullable(cernImgurl).ifPresent(insertCern::setImgUrl);
        Optional.ofNullable(videoUrl).ifPresent(insertCern::setVideoUrl);
        Optional.ofNullable(visible).ifPresent(insertCern::setTopicVisible);
        insertCern.setState(0);
        save(insertCern);
        return MapUtils.buildSuccessMap(Constants.SUCCESS, PgConstants.PG_ERROR_CODE_33000_MSG, null);
    }

    @Override
    public Map<String, Object> delCern(Integer id, Integer loginUserId) {
        if (id == null) {
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30021, PgConstants.PG_ERROR_CODE_30021_MSG);
        }
        Concern concernFind = concernMapper.getOne(id);
        if (concernFind != null) {
            if (Objects.equals(concernFind.getUserId(), loginUserId)) {
                Integer result = concernMapper.delConcern(id);
                if (result > 0) {
                    return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_39000_MSG, null);
                }
            } else {
                return MapUtils.buildSuccessMap(PgConstants.PG_ERROR_CODE_30029, PgConstants.PG_ERROR_CODE_30029_MSG, null);
            }
        } else {
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30031, PgConstants.PG_ERROR_CODE_30031_MSG);
        }

        return PgConstants.MAP_500;
    }

    @Override
    public Map<String, Object> starRandom(Integer type, Integer n) {
        Map<String, Object> map = new HashMap<>();
        try {
            Optional.ofNullable(n).orElse(10);
            List<Concern> randomList = concernMapper.starRandom(type, n);
//            map.put(Constants.STATE, Constants.MSG_SUCCESS);
//            map.put(PgConstants.PG_RESULT, Optional.ofNullable(randomList).orElse(null));
//            return map;
            return MapUtils.buildSuccessMap(Constants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, Optional.ofNullable(randomList).orElse(null));
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> getMyFollowList(Integer loginUserId, Integer start, Integer pageSize) {
        try {
            start = Optional.ofNullable(start).orElse(0);
            pageSize = Optional.ofNullable(pageSize).orElse(0);
            if (Objects.equals(loginUserId, null)) {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30000, PgConstants.PG_ERROR_CODE_30000_MSG);
            }
            AttentionParam attentionParam = new AttentionParam();
            attentionParam.setFromId(loginUserId);
            List<UserAttention> attentionIds = concernMapper.getAttentionIds(loginUserId);
            List<Integer> ids = new ArrayList<>();
            if (attentionIds.size() > 0) {
                ids.addAll(attentionIds.stream().map(UserAttention::getToUserId).collect(Collectors.toList()));
            }
            List<MyFollowVo> myFollowVos = concernMapper.myFollowList(ids, start * pageSize, pageSize);
            myFollowVos.stream().forEach(s -> {
                if (!Objects.equals(s.getFromId(), null))
                    s.setPageViews(pageViwesService.getPageViwesByInternal(1, s.getFromId()));
                else
                    s.setPageViews(pageViwesService.getPageViwesByInternal(1, s.getId()));
            });
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, myFollowVos);
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }

    }

    @Override
    public List<MyFollowVo> queryMyConcernList(Integer accountId) {
        if (accountId == null) {
            return null;
        }
        return concernMapper.myConcernList(accountId);

    }

    @Override
    public Map<String, Object> starConcern(Integer start, Integer pageSize) {
        try {
            start = Optional.ofNullable(start).orElse(0);
            pageSize = Optional.ofNullable(pageSize).orElse(0);
            List<MyFollowVo> myFollowVos = concernMapper.starConcern(start * pageSize, pageSize);
            myFollowVos.stream().forEach(s -> {
                if (!Objects.equals(s.getFromId(), null))
                    s.setPageViews(pageViwesService.getPageViwesByInternal(1, s.getFromId()));
                else
                    s.setPageViews(pageViwesService.getPageViwesByInternal(1, s.getId()));
            });
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, myFollowVos);
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }

    @Override
    public Integer fromConcern(Integer fromId, Integer fromType, Object fromObj) {
        if (Objects.equals(fromId, null)) {
            return 0;
        }
        if (Objects.equals(fromType, null)) {
            return 0;
        }
        if (Objects.equals(fromObj, null)) {
            return 0;
        }
        switch (fromType) {
            case Constants.DYNAMIC_LIVE:
                //直播
                LiveInfo liveInfo = (LiveInfo) fromObj;
                Concern concern = new Concern();
                concern.setFromId(fromId);
                concern.setFromType(1);
                concern.setType(5);
                concern.setCreateTime(new Date().getTime());
                if (!Objects.equals(liveInfo.getBgmUrl(), null)) {
                    concern.setImgUrl(liveInfo.getBgmUrl());//设置动态图片为直播的背景图片
                }
                concern.setTopicTitle(liveInfo.getTitle());
                concern.setTopicVisible(1);
                concern.setUserId(liveInfo.getUserId());
                concern.setState(0);
                return concernMapper.insert(concern);
            case Constants.DYNAMIC_ACTIVITY:
                //活动
                Activity activity = (Activity) fromObj;
                Concern concernActivity = new Concern();
                concernActivity.setFromId(fromId);
                concernActivity.setFromType(fromType);
                concernActivity.setType(2);
                concernActivity.setCreateTime(new Date().getTime());
                if (!Objects.equals(activity.getImgUrls(), null)) {
                    concernActivity.setImgUrl(activity.getImgUrls());
                }
                concernActivity.setTopicTitle(activity.getTitle());
                concernActivity.setTopicContent(activity.getDescContent());
                concernActivity.setTopicVisible(1);
                concernActivity.setUserId(activity.getUserId());
                concernActivity.setState(0);
                return concernMapper.insert(concernActivity);
            case Constants.DYNAMIC_CIRCLE:
                //帖子
                CircleItem circleItem = (CircleItem) fromObj;
                Concern concernItem = new Concern();
                concernItem.setFromId(fromId);
                concernItem.setFromType(fromType);
                concernItem.setType(6);
                concernItem.setCreateTime(new Date().getTime());
                concernItem.setTopicTitle(circleItem.getTitle());
                concernItem.setTopicContent(circleItem.getContent());
                concernItem.setTopicVisible(1);
                concernItem.setUserId(circleItem.getCreateId());
                concernItem.setState(0);
                return concernMapper.insert(concernItem);
        }
        return 0;
    }

    @Override
    public Map<String, Object> getOne(Integer concernId, Integer accountId) {
        try {
            if (Objects.equals(concernId, null)) {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30021, PgConstants.PG_ERROR_CODE_30021_MSG);
            }
            MyFollowVo myFollowVo = concernMapper.getOne(concernId);
//            if (!Objects.equals(myFollowVo, null)) {
//                myFollowVo.setTopicContent("<p>" + myFollowVo.getTopicContent() + "</p>");
//                if (myFollowVo.getImgUrl() != null) {
//                    if (myFollowVo.getImgUrl().contains(",")) {
//                        StringBuilder sb = new StringBuilder();
//                        String[] imgOne = myFollowVo.getImgUrl().split(",");
//                        for (int i = 0; i < imgOne.length; i++) {
//                            sb.append("<img src='http://image.tiyujia.com/" + imgOne[i] + "'></img>");
//                        }
//                        myFollowVo.setTopicContent(myFollowVo.getTopicContent() + "</br>" + sb.toString());
//                    }
//                }
//            }
            CollectionParam param = new CollectionParam();
            Boolean isCollection = false;

            if (!Objects.equals(accountId, null)) {
                param.setUserId(accountId);
                param.setModel(Constants.MODEL_CONCERN);
                param.setModelId(concernId);
                CollectionVo collectionFind = collectionMapper.existCollection(param);
                if (!Objects.equals(collectionFind, null)) {
                    isCollection = true;
                }
            }
            Map resultMap = new HashMap<>();
            resultMap.put("concern", myFollowVo);
            resultMap.put("isCollection", isCollection);
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, resultMap);
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }

}
