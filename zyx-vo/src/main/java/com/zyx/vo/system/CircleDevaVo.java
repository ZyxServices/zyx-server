package com.zyx.vo.system;

/**
 * Created by MrDeng on 2016/9/23.
 */
public class CircleDevaVo extends BaseDevaVo {
    private String title;
//    private Integer createId;
//    private Long createTime;
    private Integer itemCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public Integer getCreateId() {
//        return createId;
//    }
//
//    public void setCreateId(Integer createId) {
//        this.createId = createId;
//    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }
}
