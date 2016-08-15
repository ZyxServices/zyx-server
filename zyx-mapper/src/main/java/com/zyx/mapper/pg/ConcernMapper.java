package com.zyx.mapper.pg;

import com.zyx.entity.pg.Concern;
import com.zyx.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xw on 16-6-12.
 */
@Repository("concrenMapper")
public interface ConcernMapper extends BaseMapper<Concern> {
    List<Concern> starRandom(@Param("type") Integer type, @Param("n") Integer n);
}
