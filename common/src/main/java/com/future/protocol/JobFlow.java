package com.future.protocol;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zcd
 * @date 2019-08-22 11:38
 */
@Data
public class JobFlow implements Serializable
{
    private static final long serialVersionUID = 7373926702594641247L;
    /** etl job 节点列表 */
    private List<EtlProtocolNode> etlProtocolList;

    /** schedule cron 表达式*/
    private String cron;

    /** 流程id */
    private long flowId;
}

