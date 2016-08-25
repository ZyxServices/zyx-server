package com.zyx.mapper.collection;

import com.zyx.entity.collection.Collection;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.collection.CollectionParam;
import com.zyx.vo.collection.CollLiveVo;
import com.zyx.vo.collection.CollectionVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MrDeng on 2016/8/16.
 */
@Repository("collectionMapper")
public interface CollectionMapper extends BaseMapper<Collection> {
    List<CollectionVo> selectCollections(CollectionParam param);

    List<Integer> selectModelIds(CollectionParam param);

    CollLiveVo selectCollLiveInfo(Integer id);

    List<CollectionVo> myCollectionList(CollectionParam param);
}
