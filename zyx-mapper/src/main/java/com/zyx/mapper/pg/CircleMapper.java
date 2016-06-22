package com.zyx.mapper.pg;

import com.zyx.entity.pg.Circle;
import com.zyx.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XiaoWei on 2016/6/13.
 */
@Repository("circleMapper")
public interface CircleMapper extends BaseMapper<Circle> {
    List<Circle> circleList(Integer max);

    int setMaster(@Param("circle_id") Integer circle_id, @Param("master_id")Integer master_id, Integer account_id);
}
