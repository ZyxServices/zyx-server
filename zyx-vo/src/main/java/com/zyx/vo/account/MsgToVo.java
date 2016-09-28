package com.zyx.vo.account;

import java.io.Serializable;

/**
 * Created by wms on 2016/9/28.
 *
 * @author WeiMinSheng
 * @version V1.0
 *          Copyright (c)2016 tyj-版权所有
 * @since 2016/9/28
 */
public class MsgToVo implements Serializable {
    private static final long serialVersionUID = 4590490161268774867L;

    private String toUri;

    private String toContent;

    public String getToUri() {
        return toUri;
    }

    public void setToUri(String toUri) {
        this.toUri = toUri;
    }

    public String getToContent() {
        return toContent;
    }

    public void setToContent(String toContent) {
        this.toContent = toContent;
    }
}
