package com.zyx.service.system.impl;

import com.zyx.constants.pg.PgConstants;
import com.zyx.entity.system.Comment;
import com.zyx.mapper.system.CommentMapper;
import com.zyx.service.BaseServiceImpl;
import com.zyx.service.system.CommentService;
import com.zyx.utils.MapUtils;
import com.zyx.vo.pg.CommentVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.service.system.impl
 * Create by XiaoWei on 2016/8/26
 */
@Service("commentService")
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService {
    public CommentServiceImpl() {
        super(Comment.class);
    }

    @Resource
    private CommentMapper commentMapper;

    @Override
    public Map<String, Object> addComment(Integer commentType, Integer commentId, String commentContent, Integer commentAccount, Integer commentState) {
        try {
            if (Objects.equals(commentType, null)) {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30034, PgConstants.PG_ERROR_CODE_30034_MSG);
            }
            if (Objects.equals(commentId, null)) {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30035, PgConstants.PG_ERROR_CODE_30035_MSG);
            }
            if (Objects.equals(commentContent, null) || Objects.equals(commentContent, "")) {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30010, PgConstants.PG_ERROR_CODE_30010_MSG);
            }
            if (Objects.equals(commentAccount, null)) {
                return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30036, PgConstants.PG_ERROR_CODE_30036_MSG);
            }
            Comment comment = new Comment();
            comment.setCommentType(commentType);
            comment.setCommentId(commentId);
            comment.setCommentAccount(commentAccount);
            comment.setCommentContent(commentContent);
            comment.setCreateTime(new Date().getTime());
            comment.setCommentState(Optional.ofNullable(commentState).orElse(0));
            Integer result = mapper.insert(comment);
            if (result > 0)
                return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_33000_MSG, null);
            else
                return PgConstants.MAP_500;
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }

    @Override
    public Map<String, Object> queryComment(Integer commentType, Integer commentId) {
        if (Objects.equals(commentType, null)) {
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30034, PgConstants.PG_ERROR_CODE_30034_MSG);
        }
        if (Objects.equals(commentId, null)) {
            return MapUtils.buildErrorMap(PgConstants.PG_ERROR_CODE_30035, PgConstants.PG_ERROR_CODE_30035_MSG);
        }
        try {
            List<CommentVo> commentVos = commentMapper.commentQuery(commentType, commentId);
            return MapUtils.buildSuccessMap(PgConstants.SUCCESS, PgConstants.PG_ERROR_CODE_34000_MSG, commentVos);
        } catch (Exception e) {
            e.printStackTrace();
            return PgConstants.MAP_500;
        }
    }
}
