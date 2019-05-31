package com.future.kettle;

/**
 * Created by zcd on 2019-05-28
 */
public class KettleFactory
{
    /**
     * ETL- tools
     */

    /**
     * SUM(Quantity) - 在“数量”字段中添加值。
     * PERCENTILE(Users per day, 50) - 返回“每日用户数”字段的所有值的第50个百分位数。
     * ROUND(Revenue Per User, 0) - 将每用户收入字段四舍五入到0位。
     * SUBSTR(Campaign, 1, 5) - 返回Campaign字段的前5个字符。
     * REGEXP_EXTRACT(Pipe delimited values, '^([a-zA-Z_]*)(\\|)') - 提取管道分隔字符串中的第一个值。
     * DATE_DIFF(Start Date, End Date) - 计算开始日期和结束日期之间的天数。
     * TODATE(concat(Year, '-', Month Number, '-', Day Number), "DEFAULT_DASH", "%Y%m%d") - 通过连接包含有效日期部分的单独字段来创建日期
     */


    /**
     * CASE
     *     WHEN Country IN ("USA","Canada","Mexico")THEN "North America"
     *     WHEN Country IN ("England","France")THEN "Europe"
     *     ELSE "Other"
     * END
     */

    /**
     * CASE WHEN Country ISO Code = "US"  AND Medium = "cpc" THEN "US - Paid" ELSE "other" END
     *
     * CASE WHEN REGEXP_MATCH(Video Title, ".*Google Analytics*")
     * AND is_livestream = TRUE OR Video Length > 120 THEN "GA LIVE or LONG" END
     */


    /**
     * CASE WHEN Medium != "cpc" THEN "free" ELSE "paid" END
     * CASE WHEN Time on Page <= 90 THEN 1 ELSE 0 END
     */
}
