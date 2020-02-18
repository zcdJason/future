package com.future.dataModel;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据源 存储信息
 */
@Data
public class StoreInfo implements Serializable{

    private static final long serialVersionUID = -8008678069934959606L;
    /** 数据存储系统 */
    private StoreEngine storeEngine;

    /** 全量 | 增量 */
    private StoreGranularity storeGranularity;

    /** jdbc链接信息 */
    private JDBCInfo jdbcInfo;

    /** 文件存储信息 */
    private FileInfo fileInfo;
}
