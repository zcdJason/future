package com.future.protocol;

/**
 * @author zcd
 * @date 2019-08-22 11:31
 */
public enum ExecEngine
{
    /**spark 引擎 */
    spark,

    /** 数据库自身查询引擎 */
    DbSelf,

    /** hadoop-MapReduce */
    MapReduce
}
