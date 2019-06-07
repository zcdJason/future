package com.future.bootstrap.web;

/**
 * @author zcd
 * @date 2019-05-30 15:15
 */
public class FeiLongExeResVo
{
    private String result;
    private String msg;

    /**
     * job-id
     */
    private String executionId;

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public String getExecutionId()
    {
        return executionId;
    }

    public void setExecutionId(String executionId)
    {
        this.executionId = executionId;
    }
}
