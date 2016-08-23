package com.zyx.mapper.collection;

import com.zyx.entity.collection.Collection;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.collection.CollectionParam;
import com.zyx.vo.collection.CollLiveVo;
import com.zyx.vo.collection.CollectionVo;

import java.util.List;

/**
 * Created by MrDeng on 2016/8/16.
 */
public interface CollectionMapper extends BaseMapper<Collection> {
    public List<CollectionVo> selectCollections(CollectionParam param);
    public List<Integer> selectModelIds(CollectionParam param);
    public void deleteCollection(CollectionParam param);
    public CollLiveVo selectCollLiveInfo(Integer id);
}
