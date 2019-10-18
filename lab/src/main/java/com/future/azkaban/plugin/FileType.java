package com.future.azkaban.plugin;

public enum FileType
{
    csv,
    hive,
    pkl,

    /** spark save file type **/
    parquet, json, text, orc
}
