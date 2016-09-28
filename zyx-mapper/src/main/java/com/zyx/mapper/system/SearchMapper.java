package com.zyx.mapper.system;

import com.zyx.entity.activity.Combination;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.system.SearchParam;
import com.zyx.vo.system.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Rainbow on 2016/8/23.
 */
@Repository("searchMapper")
public interface SearchMapper extends BaseMapper<Combination> {

    /**
     * 查询活动模块
     * @param searchParam
     * @return
     */
    List<SearchActivityVo> searchActivtiy(SearchParam searchParam);

    /**
     * 查询用户模块
     * @param searchParam
     * @return
     */
    List<SearchAccountVo> searchAccount(SearchParam searchParam);

    /**
     * 查询当前用户未关注的用户
     * @param searchParam
     * @return
     */
    List<SearchAccountVo> searchAccountByNO(SearchParam searchParam);

    /**
     * 查询圈子模块
     * @param searchParam
     * @return
     */
    List<SearchCirleVo> searchCirle(SearchParam searchParam);

    /**
     * 查询未关注的圈子模块
     * @param searchParam
     * @return
     */
    List<SearchCirleVo> searchCirleByNo(SearchParam searchParam);

    /**
     * 查询直播模块
     * @param searchParam
     * @return
     */
    List<SearchLiveVo> searchLive(SearchParam searchParam);

    /**
     * 查询动态模块
     * @param searchParam
     * @return
     */
    List<SearchConcernVo> searchConcern(SearchParam searchParam);

    /**
     * 查询帖子模块
     * @param searchParam
     * @return
     */
    List<SearchPostsVo> searchPosts(SearchParam searchParam);
}
