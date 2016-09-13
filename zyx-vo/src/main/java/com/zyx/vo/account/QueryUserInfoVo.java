package com.zyx.vo.account;

/**
 * Created by Rainbow on 2016/8/15.
 */
public class QueryUserInfoVo {

    /**
     * 表ID
     */
    private Integer id;

    /**
     * 用户账号
     */
    private String name;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户昵称
     */
    private String avatar;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户出生年月
     */
    private Long birthday;

    /**
     * 用户性别 （1男 0女）
     */
    private Integer sex;

    /**
     * 用户身份证
     */
    private String idcard;

    /**
     * 是否屏蔽（0 正常，1 屏蔽）
     */
    private Integer mask;

    /**
     * 标识官方账号1是0不是
     */
    private Integer offcial;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Integer getMask() {
        return mask;
    }

    public void setMask(Integer mask) {
        this.mask = mask;
    }

    public Integer getOffcial() {
        return offcial;
    }

    public void setOffcial(Integer offcial) {
        this.offcial = offcial;
    }
}
