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
     *发布圈子
     * @param title 圈子标题
     * @param createId 圈子创建者id
     * @param details 内容
     * @param headImgUrl 圈子头像url
     */
    Map<String,Object> insertCircle(String title, Integer createId, Integer state,Integer type,String details, String headImgUrl);


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
    Map<String,Object> addCern(Integer userId,Integer type,String cernTitle,String content,String  cernImgurl,String videoUrl,Integer visible);

    /**
     * 各模块点赞
     * @param body_id
     * @param body_type
     * @param account_id
     * @return
     */
    Map<String,Object> addZan(Integer body_id,Integer body_type,Integer account_id);

    /**
     * 各主体添加关注
     * @param concernId 主体id
     * @param concern_type 主体类型
     * @accountId 添加关注的人
     * @return
     */
    Map<String,Object> addMyConcern(Integer concernId,Integer concern_type,Integer accountId);

    /**
     * 圈子列表
     * @param max 指定最大条数为多少
     * @return
     */
    Map<String, Object> circleList(Integer max);

    /**
     *  明星动态随机n条数据
     *  @type 类型，1为个人，2为活动，3为明星
     * @param n
     * @return
     */
    Map<String,Object> starRandom(Integer type,Integer n);


    /**
     * 圈子发布帖子
     * @param circle_id
     * @param create_id
     * @param title
     * @param content
     * @return
     */
    Map<String,Object> addCircleItem(Integer circle_id,Integer create_id,String title,String content);

    /**
     * 圈子设置圈主
     * @param circle_id
     * @param master_id
     * @param account_id
     * @return
     */
    Map<String,Object> setMaster(Integer circle_id,Integer master_id,Integer account_id);

    /**
     * 删除圈子
     * @param circle_id
     * @return
     */
    Map<String, Object> delete(Integer circle_id);

}
