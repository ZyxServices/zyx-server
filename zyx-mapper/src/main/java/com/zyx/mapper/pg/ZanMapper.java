package com.zyx.mapper.pg;

import com.zyx.entity.pg.Zan;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.pg.ZanVo;
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
    List<Integer> countZanByBodyId(ZanVo vo);
}
