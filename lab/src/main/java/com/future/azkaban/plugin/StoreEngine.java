package com.future.azkaban.plugin;

public enum StoreEngine
{
    hive,
    mysql,
    oracle,
    mongoDB,
    kudu,
    hbase,
    es,
    tiDB,
    alluxio,

    local,
    hdfs;
}
