package com.zyx.service.pg;

import com.zyx.entity.pg.Circle;
import com.zyx.vo.pg.CircleListVo;
import com.zyx.service.BaseService;
import com.zyx.vo.pg.DevaCircleVo;
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
    Map<String, Object> insertCircle(String title, Integer createId, Integer circleType, String details, String headImgUrl, Integer tag,Long groupId);

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


    Map<String, Object> getOne(Integer circleId, Integer accountId);

    Map<String, Object> closeMaster(Integer circleId, Integer accountId);

    Map<String, Object> updateHeadImg(String headImgUrl, Integer circleId);

    Map<String, Object> setAdmins(Integer createId, String adminIds, Integer circleId);

    /**
     * 我创建的圈子列表
     *
     * @param createId 创建者id
     * @return
     */
    List<CircleListVo> myCreateList(Integer createId);

    /**
     * 我关注的圈子列表
     *
     * @param accountId 用户id
     * @return
     */
    List<CircleListVo> myConcernList(Integer accountId);

    /**
     *  获取精选圈子数据，max为指定最多条数，按jx圈子排序
     * @param max
     * @return
     */
    Map<String, Object> jxCircle(Integer max);

    List<DevaCircleVo> getDevaCircle(List<Integer> ids);
}
