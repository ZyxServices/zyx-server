package com.zyx.rpc.activity.impl;

import com.zyx.constants.Constants;
import com.zyx.rpc.activity.PageViwesFacade;
import com.zyx.service.activity.PageViwesService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by SubDong on 16-6-27.
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title PageViwesFacade
 * @package com.zyx.rpc.activity.impl
 * @update 16-6-27 上午11:34
 */
@Service("pageViwesFacade")
public class PageViwesFacadeImpl implements PageViwesFacade {
    @Resource
    private PageViwesService pageViwesService;

    private static Logger logger = Logger.getLogger(ActivityFacadeImpl.class);

    @Override
    public void pageViwes(Integer types, Integer typeId) {
        pageViwesService.pageViwes(types, typeId);
    }

    @Override
    public Map<String, Object> getPageViwes(Integer types, Integer typeId) {
        try {
            return pageViwesService.getPageViwes(types, typeId);
        } catch (Exception e) {
            logger.error(e);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(Constants.STATE, Constants.ERROR_500);
            map.put(Constants.ERROR_MSG, Constants.MSG_ERROR);
            return map;
        }
    }
}
