package com.zyx.vo.pg;

import java.io.Serializable;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.vo.pg
 * Create by XiaoWei on 2016/8/16
 */
public class UserAuthVo implements Serializable {
    private String authInfo;

    public String getAuthInfo() {
        return authInfo;
    }

    public void setAuthInfo(String authInfo) {
        this.authInfo = authInfo;
    }
}
