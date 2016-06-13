package com.zyx.entity.activity;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Rainbow on 16-6-12.
 * <p>
 * 活动
 *
 * @author SubDong
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title com.zyx.entity.activity
 */
public class Activity extends BaseEntity {

    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Long id;

    /**
     * 创建者
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Long createId;

    /**
     * 活动标题
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String title;

    /**
     * 活动图片
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String imgUrls;

    /**
     * 活动描述
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String desc;

    /**
     * 活动开始时间
     */
    @Column
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date startTime;

    /**
     * 活动结束时间
     */
    @Column
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date endTime;

    /**
     * 报名截至时间
     */
    @Column
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date lastTime;

    /**
     * 活动人数上限
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer maxPeople;

    /**
     * 活动可见范围 0 所有可见, 1 朋友可见
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer visible;

    /**
     * 咨询电话
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String phone;

    /**
     * 活动价格
     */
    @Column
    @ColumnType(jdbcType = JdbcType.DECIMAL)
    private double price;

    /**
     * 活动分类
     * 0 线上活动, 1  线下活动
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer type;

    /**
     * 线上活动跳转地址
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String targetUrl;

    /**
     * 活动地址
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String address;

    /**
     * 活动启用状态
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer activityType;

    /**
     * 活动是否需要审核（活动发起者审核）
     * 0 不许要审核 , 1 需要审核
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer examine;

    /**
     * 报名活动模板
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String memberTemplate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Integer getExamine() {
        return examine;
    }

    public void setExamine(Integer examine) {
        this.examine = examine;
    }

    public String getMemberTemplate() {
        return memberTemplate;
    }

    public void setMemberTemplate(String memberTemplate) {
        this.memberTemplate = memberTemplate;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", createId=" + createId +
                ", title='" + title + '\'' +
                ", imgUrls='" + imgUrls + '\'' +
                ", desc='" + desc + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", lastTime=" + lastTime +
                ", maxPeople=" + maxPeople +
                ", visible=" + visible +
                ", phone='" + phone + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", targetUrl='" + targetUrl + '\'' +
                ", address='" + address + '\'' +
                ", activityType=" + activityType +
                ", examine=" + examine +
                ", memberTemplate='" + memberTemplate + '\'' +
                '}';
    }
}
