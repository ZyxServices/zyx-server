package com.zyx.vo.pg;

import com.zyx.entity.pg.Circle;
import com.zyx.entity.pg.CircleItem;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.entity.pg.dto
 * Create by XiaoWei on 2016/8/15
 */
public class CircleItemLunBoVo extends CircleItem {
    private UserVo userVo;
    private String tjImgae_url;
    private Circle circleVo;

    public String getTjImgae_url() {
        return tjImgae_url;
    }

    public void setTjImgae_url(String tjImgae_url) {
        this.tjImgae_url = tjImgae_url;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }

    public Circle getCircleVo() {
        return circleVo;
    }

    public void setCircleVo(Circle circleVo) {
        this.circleVo = circleVo;
    }
}
