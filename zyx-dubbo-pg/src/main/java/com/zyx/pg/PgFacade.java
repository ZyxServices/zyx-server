package com.zyx.pg;

import java.util.Map;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.pg
 * Create by XiaoWei on 2016/6/14
 */
public interface PgFacade {
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
     *
     * @param accountId 用户id
     * @return
     */
    Map<String,Object> circleMeet(Integer accountId,Integer circleId);
}
