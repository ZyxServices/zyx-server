package com.zyx.mapper.system;

import com.zyx.entity.system.Comment;
import com.zyx.mapper.BaseMapper;
import com.zyx.vo.pg.CommentVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.mapper.system
 * Create by XiaoWei on 2016/8/26
 */
@Repository("commentMapper")
public interface CommentMapper extends BaseMapper<Comment> {

    List<CommentVo> commentQuery(@Param("type") Integer type, @Param("commentId") Integer commentId);

}
