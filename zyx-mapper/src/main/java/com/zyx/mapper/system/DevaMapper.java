package com.zyx.mapper.system;

import com.zyx.entity.system.Devaluation;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.system.DevaParam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SubDong on 16-6-28.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title DevaMapper
 * @package com.zyx.mapper.activity
 * @update 16-6-28 下午3:13
 */
@Repository("devaMapper")
public interface DevaMapper extends BaseMapper<Devaluation> {
    /**
     * 删除首推项
     *
     * @param devaluation
     */
    int deleteDevaluation(Devaluation devaluation);

    /**
     * 查询首推项
     * @param param
     * @return
     */
    List<Devaluation> queryDevas(DevaParam param);

    /**
     * 查询相关类型的所有首推ids
     * @param param
     * @return
     */
    List<Integer> queryModelIds(DevaParam param);

}
