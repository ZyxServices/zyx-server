package com.zyx.rpc.system.impl;

import com.zyx.constants.Constants;
import com.zyx.param.system.SearchParam;
import com.zyx.rpc.system.SearchFacade;
import com.zyx.service.system.SearchService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rainbow on 2016/8/23.
 */
@Service("searchFacade")
public class SearchFacadeImpl implements SearchFacade {
    @Resource
    SearchService searchService;

    private static Logger logger = Logger.getLogger(SearchFacadeImpl.class);

    @Override
    public Map<String, Object> modularSearch(SearchParam searchParam) {
        try {
            return searchService.modularSearch(searchParam);
        } catch (Exception e) {
            e.printStackTrace();
            return return500(e);
        }

    }

    @Override
    public Map<String, Object> searchAccountByNO(SearchParam searchParam) {
        try {
            return searchService.searchAccountByNO(searchParam);
        } catch (Exception e) {
            e.printStackTrace();
            return return500(e);
        }
    }

    @Override
    public Map<String, Object> searchCirleByNo(SearchParam searchParam) {
        try {
            return searchService.searchCirleByNo(searchParam);
        } catch (Exception e) {
            e.printStackTrace();
            return return500(e);
        }
    }


    private Map<String, Object> return500(Exception e) {
        logger.error(e);
        Map<String, Object> map = new HashMap<>();
        map.put(Constants.STATE, Constants.ERROR_500);
        map.put(Constants.ERROR_MSG, Constants.MSG_ERROR);
        return map;
    }
}
