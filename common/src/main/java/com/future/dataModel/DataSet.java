package com.future.dataModel;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zcd
 * @date 2019-08-22 13:39
 */
@Data
public class DataSet implements Serializable {
    private static final long serialVersionUID = -6806548629495924335L;

    /**
     * 数据集类型
     */
    private DataSetType dsType;
    /**
     * 数据集存储系统
     **/
    private StoreInfo storeInfo;

    /**
     数据集的参数信息
     **/
    private DataSetParameter parameter;
    /**
     * 数据集的元数据信息
     **/
    private MetaInfo metaInfo;
}
