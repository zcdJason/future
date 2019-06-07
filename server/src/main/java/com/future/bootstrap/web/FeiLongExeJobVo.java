package com.future.bootstrap.web;

import java.util.Map;

/**
 * @author zcd
 * @date 2019-05-30 15:03
 */
public class FeiLongExeJobVo
{

    @Override
    public String toString()
    {
        return "FeiLongExeJobVo{" +
                "jobName='" + jobName + '\'' +
                ", projectId='" + projectId + '\'' +
                ", jobParams=" + jobParams +
                '}';
    }

    /**
     * 作业名称
     */
    private String jobName;

    /**
     * 项目id
     */
    private String projectId;

    /**
     * 触发条件/调度策略
     */
    private Map<String, String> jobParams;


    public String getJobName()
    {
        return jobName;
    }

    public void setJobName(String jobName)
    {
        this.jobName = jobName;
    }

    public String getProjectId()
    {
        return projectId;
    }

    public void setProjectId(String projectId)
    {
        this.projectId = projectId;
    }

    public Map<String, String> getJobParams()
    {
        return jobParams;
    }

    public void setJobParams(Map<String, String> jobParams)
    {
        this.jobParams = jobParams;
    }
}
