package com.zyx.entity.account;

import com.zyx.entity.BaseEntity;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * Created by WeiMinSheng on 2016/6/12.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @title AccountInfo.java
 */
@Table(name = "user")
public class AccountInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column
    @ColumnType(jdbcType = JdbcType.CHAR)
    private String phone;

    @Column
    @ColumnType(jdbcType = JdbcType.CHAR)
    private String password;

    @Column
    @ColumnType(jdbcType = JdbcType.CHAR)
    private String nickname;

    @Column
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer sex;

    private String avatar;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                '}';
    }
}
