package com.zyx.rpc.system;

import com.zyx.param.system.SearchParam;

import java.util.Map;

/**
 * Created by Rainbow on 2016/8/23.
 */
public interface SearchFacade {

    /**
     * 分模块检索数据
     *
     * @return
     */
    Map<String, Object> modularSearch(SearchParam searchParam);

}
