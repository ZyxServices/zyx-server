package com.zyx.entity.activity;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Table;
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
@Table(name = "activity")
public class Activity extends BaseEntity {

    /**
     * 创建者
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer create_id;

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
    private String img_urls;

    /**
     * 活动描述
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String desc_content;

    /**
     * 活动开始时间
     */
    @Column
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date start_time;

    /**
     * 活动结束时间
     */
    @Column
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date end_time;

    /**
     * 报名截至时间
     */
    @Column
    @ColumnType(jdbcType = JdbcType.DATE)
    private Date last_time;

    /**
     * 活动人数上限
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer max_people;

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
    private String target_url;

    /**
     * 活动地址
     */
    @Column
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String address;

    /**
     * 活动启用状态 (0 不起用，1 启用)
     */
    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer activity_type;

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
    private String member_template;


    public Integer getCreate_id() {
        return create_id;
    }

    public void setCreate_id(Integer create_id) {
        this.create_id = create_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg_urls() {
        return img_urls;
    }

    public void setImg_urls(String img_urls) {
        this.img_urls = img_urls;
    }

    public String getDesc_content() {
        return desc_content;
    }

    public void setDesc_content(String desc_content) {
        this.desc_content = desc_content;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getLast_time() {
        return last_time;
    }

    public void setLast_time(Date last_time) {
        this.last_time = last_time;
    }

    public Integer getMax_people() {
        return max_people;
    }

    public void setMax_people(Integer max_people) {
        this.max_people = max_people;
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

    public String getTarget_url() {
        return target_url;
    }

    public void setTarget_url(String target_url) {
        this.target_url = target_url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getActivity_type() {
        return activity_type;
    }

    public void setActivity_type(Integer activity_type) {
        this.activity_type = activity_type;
    }

    public Integer getExamine() {
        return examine;
    }

    public void setExamine(Integer examine) {
        this.examine = examine;
    }

    public String getMember_template() {
        return member_template;
    }

    public void setMember_template(String member_template) {
        this.member_template = member_template;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "create_id=" + create_id +
                ", title='" + title + '\'' +
                ", img_urls='" + img_urls + '\'' +
                ", desc_content='" + desc_content + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", last_time=" + last_time +
                ", max_people=" + max_people +
                ", visible=" + visible +
                ", phone='" + phone + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", target_url='" + target_url + '\'' +
                ", address='" + address + '\'' +
                ", activity_type=" + activity_type +
                ", examine=" + examine +
                ", member_template='" + member_template + '\'' +
                '}';
    }
}
