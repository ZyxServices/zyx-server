package com.zyx.concren.impl;

import com.zyx.concren.ConcrenInfoService;
import com.zyx.entity.playground.Concern;

import com.zyx.service.shop.ConcrenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by XiaoWei on 2016/6/7.
 */
@Service("concrenInfoService")
public class ConcrenInfoServiceImpl implements ConcrenInfoService {

	@Autowired
    private ConcrenService concrenService;

    @Override
    public void custom() {
        concrenService.custom();
    }

    @Override
    public void Add(Concern concern) {
        concrenService.save(concern);
    }
}
