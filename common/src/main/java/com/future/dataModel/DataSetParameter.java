package com.future.dataModel;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zcd
 * @date 2019-08-22 13:39
 */
@Data
public class DataSetParameter implements Serializable {
    private static final long serialVersionUID = -6806548629495924335L;
    /** column 信息 */
    private List<String> column;

    /** sql 信息 */
    private String sql;

    /** 标签列 */
    private String label;
}
