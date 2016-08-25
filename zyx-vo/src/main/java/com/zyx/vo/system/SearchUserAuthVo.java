package com.zyx.vo.system;

import java.io.Serializable;

/**
 * Created by Rainbow on 2016/8/24.
 */
public class SearchUserAuthVo implements Serializable {

    private Integer id;

    private String authinfo;

    private String authfile;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthinfo() {
        return authinfo;
    }

    public void setAuthinfo(String authinfo) {
        this.authinfo = authinfo;
    }

    public String getAuthfile() {
        return authfile;
    }

    public void setAuthfile(String authfile) {
        this.authfile = authfile;
    }
}
