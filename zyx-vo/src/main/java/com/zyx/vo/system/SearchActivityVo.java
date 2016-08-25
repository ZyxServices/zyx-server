package com.zyx.vo.system;

import com.zyx.vo.account.AccountAttentionVo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Rainbow on 2016/8/23.
 */
public class SearchActivityVo implements Serializable {
    /**
     * 主键ID
     **/
    private Integer id;
    /**
     * 创建时间
     **/
    private Long createTime;

    /**
     * 创建者(用户ID)
     */
    private AccountAttentionVo user;

    /**
     * 收藏
     */
    private Integer collection;

    /**
     * 活动标题
     */
    private String title;

    /**
     * 活动图片
     */
    private String imgUrls;

    /**
     * 活动开始时间
     */
    private Long startTime;

    /**
     * 活动结束时间
     */
    private Long endTime;

    /**
     * 报名截至时间
     */
    private Long lastTime;

    /**
     * 活动人数上限
     */
    private Integer maxPeople;

    /**
     * 咨询电话
     */
    private String phone;

    /**
     * 活动价格
     */
    private double price;

    /**
     * 活动地址
     */
    private String address;

    /**
     * 当前活动报名人数
     */
    private int memberCount;

    /**
     * 是否屏蔽(0正常 1屏蔽)
     */
    private Integer mask;

    /**
     * 当前登录用户是否收藏次活动
     */
    private boolean isColl;

    /**
     * 当前直播点赞数
     */
    private Integer zanCount;

    /**
     * 当前直播弹幕数
     */
    private Integer msgCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public AccountAttentionVo getUser() {
        return user;
    }

    public void setUser(AccountAttentionVo user) {
        this.user = user;
    }

    public Integer getCollection() {
        if (collection == null) {
            collection = 0;
        }
        return collection;
    }

    public void setCollection(Integer collection) {
        this.collection = collection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getLastTime() {
        return lastTime;
    }

    public void setLastTime(Long lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
    }

    public boolean isColl() {
        return isColl;
    }

    public void setColl(boolean coll) {
        isColl = coll;
    }

    public Integer getZanCount() {
        if(zanCount == null) zanCount = 0;
        return zanCount;
    }

    public void setZanCount(Integer zanCount) {
        this.zanCount = zanCount;
    }

    public Integer getMsgCount() {
        if(msgCount == null) msgCount = 0;
        return msgCount;
    }

    public void setMsgCount(Integer msgCount) {
        this.msgCount = msgCount;
    }
}
