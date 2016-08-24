package com.zyx.service.collection.impl;

import com.zyx.entity.collection.Collection;
import com.zyx.mapper.collection.CollectionMapper;
import com.zyx.param.collection.CollectionParam;
import com.zyx.service.BaseService;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.collection.CollectionService;
import com.zyx.vo.collection.CollectionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by MrDeng on 2016/8/16.
 */
@Service("collectionService")
public class CollectionServiceImpl extends BaseServiceImpl<Collection> implements CollectionService{
    public CollectionServiceImpl() {
        super(Collection.class);
    }
    @Autowired
    CollectionMapper collectionMapper;

    @Override
    public List<Integer> selectModelIds(CollectionParam param) {
//        Example example;
//        Example.
//        collectionMapper.selectByExample(example);
        return collectionMapper.selectModelIds(param);
    }

    @Override
    public List<CollectionVo> selectCollections(CollectionParam param) {
        return collectionMapper.selectCollections(param);
    }
}
