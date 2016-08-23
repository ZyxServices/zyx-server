package com.zyx.service.collection;

import com.zyx.entity.collection.Collection;
import com.zyx.param.collection.CollectionParam;
import com.zyx.service.BaseService;
import com.zyx.vo.collection.CollectionVo;

import java.util.List;

/**
 * Created by MrDeng on 2016/8/16.
 */
public interface CollectionService extends BaseService<Collection> {

    public List<CollectionVo> selectCollection(CollectionParam param);
    /**
     * 按照用户Id查询收藏内容
     * @param param
     * @return
     */
    public List<Integer> selectModelIds(CollectionParam param);


    public void deleteCollection(CollectionParam param);
}
