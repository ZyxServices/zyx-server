package com.zyx.service.collection;

import com.zyx.entity.collection.Collection;
import com.zyx.param.collection.CollectionParam;
import com.zyx.service.BaseService;
import com.zyx.vo.account.UserIconVo;
import com.zyx.vo.collection.CollectionVo;

import java.util.List;

/**
 * Created by MrDeng on 2016/8/16.
 */
public interface CollectionService extends BaseService<Collection> {
    List<Integer> selectModelIds(CollectionParam param);

    List<CollectionVo> selectCollections(CollectionParam param);

    List<CollectionVo> myCollectionList(Integer accountId);
    public List<UserIconVo> getCollUserIcons(Integer model, Integer modelId);

}
