package com.future.dataModel;

import lombok.Data;

@Data
public class JDBCInfo
{
    /** url 信息 */
    private String url;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /**数据库 */
    private String dataBase;
}
