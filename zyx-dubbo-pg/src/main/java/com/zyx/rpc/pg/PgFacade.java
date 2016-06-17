package com.zyx.rpc.pg;

import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.pg
 * Create by XiaoWei on 2016/6/14
 */
public interface PgFacade {
    /**
     * 圈子签到
     * @param circleId
     * @param accountId
     * @return
     */
    Map<String,Object> addMeet(Integer  circleId, Integer accountId);
    /**
     *
     * @param title 圈子标题
     * @param createId 圈子创建者id
     * @param circleMasterId 圈主
     * @param details 内容
     * @param headImgUrl 圈子头像url
     */
    Map<String,Object> insertCircle(String title, Integer createId,  Integer circleMasterId, String details, String headImgUrl);


    /**
     * 发布动态
     * @param userId
     * @param cernTitle
     * @param content
     * @param cernImgurl
     * @param videoUrl
     * @param visible
     * @return
     */
    Map<String,Object> addCern(Integer userId,String cernTitle,String content,String  cernImgurl,String videoUrl,Integer visible);

    /**
     * 各模块点赞
     * @param body_id
     * @param body_type
     * @param account_id
     * @return
     */
    Map<String,Object> addZan(Integer body_id,Integer body_type,Integer account_id);

}
