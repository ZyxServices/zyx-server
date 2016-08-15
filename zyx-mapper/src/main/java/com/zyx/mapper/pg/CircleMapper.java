package com.zyx.mapper.pg;

import com.zyx.entity.pg.Circle;
import com.zyx.entity.pg.dto.CircleListDto;
import com.zyx.entity.pg.dto.JxCircleDto;
import com.zyx.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by XiaoWei on 2016/6/13.
 */
@Repository("circleMapper")
public interface CircleMapper extends BaseMapper<Circle> {
    /**
     * 圈子列表
     *
     * @param max 指定最大条数为多少
     * @return
     */
    List<Circle> circleList(@Param("max") Integer max);

    /**
     * 判断圈子是否设置了该圈主
     *
     * @param id
     * @param master_id
     * @return
     */
    Circle existMaster(@Param("id") Integer id, @Param("master_id") Integer master_id);


    /**
     * 设置圈主
     *
     * @param circle_id
     * @param master_id
     * @param account_id
     * @return
     */
    int setMaster(@Param("circle_id") Integer circle_id, @Param("master_id") Integer master_id, Integer account_id);

    /**
     * 删除圈子
     *
     * @param circle_id
     * @return
     */
    int deleteCircle(@Param("circle_id") Integer circle_id);

    /**
     * 圈子
     *
     * @param circle_id
     * @return
     */
    int setTop(@Param("circle_id") Integer circle_id);


    /**
     * 单条
     *
     * @param id
     * @return
     */
    Circle findById(@Param("id") Integer id);

    Integer closeMaster(@Param("circleId") Integer circleId, @Param("oldMasterId") Integer oldMasterId);

    Integer updateHeadImg(@Param("headImgUrl") String headImgUrl, @Param("circleId") Integer circleId);

    Integer setAdminIds(@Param("adminIds") String adminIds, @Param("circleId") Integer circleId);

    /**
     * 级联删除帖子
     * 圈子id，
     *
     * @param circleId
     * @return
     */
    Integer deleteByCircleId(@Param("circleId") Integer circleId);

    /*
     * 根据创建者ID查询圈子列表
     *
     * @param createId 创建者ID
     * @return
     */
    List<CircleListDto> myCreateList(@Param("create_id") Integer createId);

    /**
     * 根据用户ID查询关注圈子列表
     *
     * @param accountId 用户ID
     * @return
     */
    List<CircleListDto> myConcernList(@Param("account_id") Integer accountId);


    List<JxCircleDto> jxCircle(@Param("devTypes") Integer devTypes, @Param("max") Integer max);
}
