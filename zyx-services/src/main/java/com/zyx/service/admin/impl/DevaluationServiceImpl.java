package com.zyx.service.admin.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.zyx.entity.Devaluation;
import com.zyx.mapper.activity.DevaluationMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.admin.DevaluationService;

@Service("devaluationService")
public class DevaluationServiceImpl extends BaseServiceImpl<Devaluation> implements DevaluationService {

    @Autowired
    DevaluationMapper devaluationMapper;
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public DevaluationServiceImpl() {
        super(DevaluationServiceImpl.class);
    }

    @Override
    public int deleteDevaluation(Devaluation devaluation) {
        return devaluationMapper.delete(devaluation);
    }

    @Override
    public List<Devaluation> queryDevaluation(Integer types) {
        return devaluationMapper.queryDevaluation(types);
    }

    @Override
    public List<Integer> queryDevaIds(Integer types) {
        return devaluationMapper.queryDevaIds(types);
    }

    @Override
    public List queryDevaByModel(Integer model) {
        if (model == null || model < 1 || model > 5)
            return null;
        else {

        }
        return null;
    }

}
