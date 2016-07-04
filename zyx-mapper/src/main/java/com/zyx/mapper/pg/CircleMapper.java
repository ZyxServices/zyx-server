package com.zyx.mapper.pg;

import com.zyx.entity.pg.Circle;
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
     * 圈子查询执行数据
     *
     * @param max
     * @return
     */
    List<Circle> top(@Param("max") Integer max);

    /**
     * 根据id列表查询圈子数据
     * @param ids
     * @return
     */
    List<Circle> queryCircleDeva(@Param("ids") List<Integer> ids);

}
