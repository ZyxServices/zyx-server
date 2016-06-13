package com.zyx.impl.pg;


import org.springframework.stereotype.Service;

import com.zyx.entity.pg.Concern;
import com.zyx.impl.BaseServiceImpl;
import com.zyx.service.pg.ConcrenService;

/**
 * Created by XiaoWei on 2016/6/7.
 */
@Service("concrenService")
public class ConcrenServicImpl extends BaseServiceImpl<Concern> implements ConcrenService {

    @Override
    public void custom() {

    }
}
