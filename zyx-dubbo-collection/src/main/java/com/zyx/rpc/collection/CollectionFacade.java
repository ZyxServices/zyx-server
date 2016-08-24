package com.zyx.rpc.collection;

import com.zyx.entity.collection.Collection;
import com.zyx.param.collection.CollectionParam;
import com.zyx.vo.collection.CollectionVo;

import java.util.List;

/**
 * Created by MrDeng on 2016/8/15.
 */
public interface CollectionFacade {
    /**
     * 添加收藏
     * @param collection
     */
    public void addCollection(Collection collection);

    /**
     * 取消收藏
     * @param id
     */
    public void cancelCollect(Integer id);

    /**
     * 取消收藏
     * @param record
     */
    public void cancelCollect(Collection record);

    /**
     * 查询收藏
     */
    public List<CollectionVo> selectCollections(CollectionParam param);

    public int count(Collection collection);
}
