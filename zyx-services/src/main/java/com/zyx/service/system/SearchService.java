package com.zyx.service.system;

import com.zyx.param.system.SearchParam;

import java.util.Map;

/**
 * Created by Rainbow on 2016/8/23.
 */
public interface SearchService {

    /**
     * 分模块检索数据
     *
     * @return
     */
    Map<String, Object> modularSearch(SearchParam searchParam);

    /**
     * 查询当前用户未关注的用户
     * @param searchParam
     * @return
     */
    Map<String, Object> searchAccountByNO(SearchParam searchParam);

    /**
     * 查询当前用户未关注的圈子
     * @param searchParam
     * @return
     */
    Map<String, Object> searchCirleByNo(SearchParam searchParam);

}
