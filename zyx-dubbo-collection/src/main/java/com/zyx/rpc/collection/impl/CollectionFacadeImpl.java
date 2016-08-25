package com.zyx.rpc.collection.impl;

import com.zyx.entity.collection.Collection;
import com.zyx.param.collection.CollectionParam;
import com.zyx.rpc.collection.CollectionFacade;
import com.zyx.service.collection.CollectionService;
import com.zyx.vo.collection.CollectionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MrDeng on 2016/8/15.
 */
@Service("collectionFacade")
public class CollectionFacadeImpl implements CollectionFacade {
    @Autowired
    CollectionService collectionService;

    @Override
    public void addCollection(Collection collection) {
        collection.setCreateTime(System.currentTimeMillis());
        collectionService.save(collection);
    }

    @Override
    public void cancelCollect(Integer id) {
        collectionService.delete(id);
    }

    @Override
    public void cancelCollect(Collection record) {
        collectionService.deleteRecords(record);
    }

    @Override
    public List<CollectionVo> selectCollections(CollectionParam param) {
        return collectionService.selectCollections(param);
    }

    @Override
    public int count(Collection collection) {
        return collectionService.selectCount(collection);
    }
}
