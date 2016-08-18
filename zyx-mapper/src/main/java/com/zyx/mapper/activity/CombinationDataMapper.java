package com.zyx.mapper.activity;

import com.zyx.entity.activity.CombinedData;
import com.zyx.vo.activity.CombinedDataVo;
import com.zyx.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rainbow on 2016/8/16.
 */
@Repository("combinationDataMapper")
public interface CombinationDataMapper extends BaseMapper<CombinedData> {

    /**
     * 多条件查询
     * @param combinedData
     * @return
     */
    List<CombinedDataVo> queryCombiationData(CombinedData combinedData);
}
