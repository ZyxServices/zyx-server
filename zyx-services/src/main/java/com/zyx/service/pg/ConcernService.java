package com.zyx.service.pg;

import com.zyx.entity.pg.Concern;
import com.zyx.service.BaseService;
import com.zyx.vo.pg.MyFollowVo;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoWei on 2016/6/7.
 */
public interface ConcernService extends BaseService<Concern> {
    Map<String, Object> addCern(Integer userId, Integer type, String cernTitle, String content, String cernImgurl, String videoUrl, Integer visible);

    Map<String, Object> delCern(Integer id, Integer loginUserId);

    Map<String, Object> starRandom(Integer type, Integer n);

    Map<String, Object> getMyFollowList(Integer loginUserId, Integer start, Integer end);

    List<MyFollowVo> queryMyConcernList(Integer accountId);

    Map<String, Object> starConcern(Integer start,Integer pageSize);

    /**
     * 自动生成动态
     *
     * @param fromId
     * @param fromType 目前3个模块用到，1：直播，2活动，3帖子（调用Constants key）
     * @param formObj
     * @return
     */
    Integer fromConcern(Integer fromId, Integer fromType, Object formObj);

    Map<String, Object> getOne(Integer concernId, Integer accountId);
}
