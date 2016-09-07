package com.zyx.vo.pg;


import com.zyx.entity.pg.Concern;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.pg.dto
 * Create by XiaoWei on 2016/8/15
 */
public class MyFollowVo extends Concern {
    UserVo userVo;
    private Integer pageViews;
    private Integer zanCounts;
    private Integer commentCounts;
    UserAuthVo userAuthVo;

    public Integer getPageViews() {
        return pageViews;
    }

    public void setPageViews(Integer pageViews) {
        this.pageViews = pageViews;
    }

    public Integer getZanCounts() {
        return zanCounts;
    }

    public void setZanCounts(Integer zanCounts) {
        this.zanCounts = zanCounts;
    }

    public Integer getCommentCounts() {
        return commentCounts;
    }

    public void setCommentCounts(Integer commentCounts) {
        this.commentCounts = commentCounts;
    }


    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public UserAuthVo getUserAuthVo() {
        return userAuthVo;
    }

    public void setUserAuthVo(UserAuthVo userAuthVo) {
        this.userAuthVo = userAuthVo;
    }
}
