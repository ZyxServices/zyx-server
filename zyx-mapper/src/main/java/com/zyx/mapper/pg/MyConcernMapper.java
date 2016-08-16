package com.zyx.mapper.pg;

import com.zyx.entity.pg.MyConcern;
import com.zyx.vo.pg.MyConcernVo;
import com.zyx.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.mapper.pg
 * Create by XiaoWei on 2016/6/20
 */
@Repository("myConcernMapper")
public interface MyConcernMapper extends BaseMapper<MyConcern> {
    Integer getCounts(@Param(value = "concernType") Integer concernType, @Param(value = "concernId") Integer concernId);

    MyConcern existConcern(@Param(value = "accountId") Integer accountId, @Param(value = "concernId") Integer concernId, @Param(value = "concernType") Integer concernType);

    List<MyConcernVo> findByParams(@Param("concernId") Integer concernId, @Param("concernType") Integer concernType);
}
