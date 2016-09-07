package com.zyx.mapper.pg;

import com.zyx.entity.attention.UserAttention;
import com.zyx.entity.pg.Concern;
import com.zyx.mapper.BaseMapper;
import com.zyx.param.account.UserConcernParam;
import com.zyx.vo.pg.MyFollowVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xw on 16-6-12.
 */
@Repository("concrenMapper")
public interface ConcernMapper extends BaseMapper<Concern> {
    List<Concern> starRandom(@Param("type") Integer type, @Param("n") Integer n);

    List<UserAttention> getAttentionIds(@Param("loginUserId") Integer logInUserId);

    List<MyFollowVo> myFollowList(@Param("ids") List<Integer> ids);

    /**
     * 我的动态列表
     */
    List<MyFollowVo> myConcernList(UserConcernParam userConcernParam);

    List<MyFollowVo> starConcern(@Param("max") Integer max);

    MyFollowVo getOne(@Param("id") Integer concernId);

    Integer delConcern(@Param("id") Integer id);

}
