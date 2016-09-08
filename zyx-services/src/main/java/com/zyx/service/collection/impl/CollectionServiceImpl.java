package com.zyx.service.collection.impl;

import com.zyx.entity.collection.Collection;
import com.zyx.mapper.collection.CollectionMapper;
import com.zyx.param.account.UserCollectionParam;
import com.zyx.param.collection.CollectionParam;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.activity.PageViwesService;
import com.zyx.service.collection.CollectionService;
import com.zyx.vo.account.UserIconVo;
import com.zyx.vo.collection.CollectionVo;
import com.zyx.vo.pg.MyFollowVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by MrDeng on 2016/8/16.
 */
@Service("collectionService")
public class CollectionServiceImpl extends BaseServiceImpl<Collection> implements CollectionService {
    public CollectionServiceImpl() {
        super(Collection.class);
    }

    @Autowired
    CollectionMapper collectionMapper;

    @Resource
    private PageViwesService pageViwesService;

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

    @Override
    public List<CollectionVo> myCollectionList(UserCollectionParam userCollectionParam) {
        if (userCollectionParam == null) {
            return null;
        }
        List<CollectionVo> list = collectionMapper.myCollectionList(userCollectionParam);
        list.stream().filter(e -> e.getId() != null).forEach(s -> s.setPageViews(pageViwesService.getPageViwesByInternal(getType(s.getModel()), s.getModelId()).getPageviews()));
        return collectionMapper.myCollectionList(userCollectionParam);
    }

    private Integer getType(Integer model) {
        switch (model) {
            case 1:
                return 2;
            case 2:
                return 0;
            case 4:
                return 3;
            case 5:
                return 1;
        }
        return 0;
    }

    @Override
    public List<UserIconVo> getCollUserIcons(Integer model, Integer modelId) {
        CollectionParam param = new CollectionParam();
        param.setModel(model);
        param.setModelId(modelId);
        return collectionMapper.getCollUserIcons(param);
    }
}
