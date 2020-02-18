package com.future.protocol;

import lombok.Data;

/**
 * @author zcd
 * @date 2019-08-19 13:44
 */
@Data
public class EtlStrategy
{
    /** 执行内容 */
    private String content;

    /** schedule cron 表达式*/
    private String cron;
}
