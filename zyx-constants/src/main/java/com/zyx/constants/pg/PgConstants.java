package com.zyx.constants.pg;

/**
 * @author XiaoWei
 * @version V 1.0
 * @package com.zyx.constants.pg
 * Create by XiaoWei on 2016/6/17
 */
public interface PgConstants {
    int PG_ERROR_CODE_30000 = 30000;
    String PG_ERROR_CODE_30000_MSG = "用户token已经失效，请重新登录";

    int PG_ERROR_CODE_30001= 30001;
    String PG_ERROR_CODE_30001_MSG = "圈子id不能为空";

    int PG_ERROR_CODE_30002= 30002;
    String PG_ERROR_CODE_30002_MSG = "圈主id不能为空";

    int PG_ERROR_CODE_30003= 30003;
    String PG_ERROR_CODE_30003_MSG = "设置人的id不能为空";

    int PG_ERROR_CODE_30004= 30004;
    String PG_ERROR_CODE_30004_MSG = "该圈子已经设置过圈主";

    String PG_RESULT = "result";
}
