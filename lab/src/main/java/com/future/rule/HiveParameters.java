package com.future.rule;

import java.util.List;

/**
 * @author Cock-a-doodle-doo!
 */
public class HiveParameters {
    /**计算源表名称*/
    private String sourceTable;
    /**落地的目标表名称*/
    private String targetTable;
    /**目标表分区字段*/
    private String partitionName;
    /**目标表分区字段*/
    private String partitionValue;

    /**需要的属性列,如果为空，则拼接后的sql使用*号代替*/
    private List<String> columns;

    /**是需要重写表*/
    private boolean overwrite;

    public boolean isOverwrite() {
        return overwrite;
    }

    public void setOverwrite(boolean overwrite) {
        this.overwrite = overwrite;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public String getSourceTable() {
        return sourceTable;
    }

    public void setSourceTable(String sourceTable) {
        this.sourceTable = sourceTable;
    }

    public String getTargetTable() {
        return targetTable;
    }

    public void setTargetTable(String targetTable) {
        this.targetTable = targetTable;
    }

    public String getPartitionName() {
        return partitionName;
    }

    public void setPartitionName(String partitionName) {
        this.partitionName = partitionName;
    }

    public String getPartitionValue() {
        return partitionValue;
    }

    public void setPartitionValue(String partitionValue) {
        this.partitionValue = partitionValue;
    }
}
