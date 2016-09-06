package com.zyx.mapper.system;

import com.zyx.entity.system.Comment;
import com.zyx.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.mapper.system
 * Create by XiaoWei on 2016/8/26
 */
@Repository("commentMapper")
public interface CommentMapper extends BaseMapper<Comment> {

}
