package com.zyx.mapper.pg;

import com.zyx.entity.pg.Zan;
import com.zyx.vo.pg.ZanCountVo;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.pg.ZanVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.mapper.pg
 * Create by XiaoWei on 2016/6/20
 */
@Repository("zanMapper")
public interface ZanMapper extends BaseMapper<Zan> {
    List<ZanCountVo> countZanByBodyId(ZanVo vo);

    Integer exist(@Param("bodyId") Integer body_id, @Param("bodyType") Integer body_type, @Param("accountId") Integer account_id);

    Integer cancelZan(@Param("bodyId") Integer body_id, @Param("bodyType") Integer body_type, @Param("accountId") Integer account_id);
}
