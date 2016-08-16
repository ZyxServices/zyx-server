package com.zyx.mapper.collection;

import com.zyx.entity.collection.Collection;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.collection.CollectionParam;
import java.util.List;

/**
 * Created by MrDeng on 2016/8/16.
 */
public interface CollectionMapper extends BaseMapper<Collection> {
    public List<Integer> selectModelIds(CollectionParam param);
}
