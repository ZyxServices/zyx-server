package com.zyx.service.pg;

import com.zyx.entity.pg.Circle;
import com.zyx.service.BaseService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by XiaoWei on 2016/6/13.
 */
public interface CircleService extends BaseService<Circle> {

    /**
     * @param title      圈子标题
     * @param createId   圈子创建者id
     * @param details    内容
     * @param headImgUrl 圈子头像url
     */
    Map<String, Object> insertCircle(String title, Integer createId, Integer circleType, String details, String headImgUrl);

    /**
     * 圈子签到
     *
     * @param accountId 用户id
     * @return
     * @circleId 圈子id
     */
    Map<String, Object> circleMeet(Integer accountId, Integer circleId);


    /**
     * 圈子列表
     *
     * @param max 指定最大条数为多少
     * @return
     */
    Map<String, Object> circleList(Integer max);

    /**
     * 圈子设置圈主
     *
     * @param circle_id
     * @param master_id
     * @param account_id
     * @return
     */
    Map<String, Object> setMaster(Integer circle_id, Integer master_id, Integer account_id);


    /**
     * 删除圈子
     *
     * @param circle_id
     * @return
     */
    Map<String, Object> delete(Integer circle_id);

    /**
     * 圈子
     *
     * @param circle_id
     * @return
     */
    Map<String, Object> setTop(Integer circle_id);


    List<Circle> queryCircleDeva();

    Map<String, Object> getOne(Integer circleId, Integer accountId);


}
