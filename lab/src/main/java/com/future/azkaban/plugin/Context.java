package com.future.azkaban.plugin;

import java.io.Serializable;

public class Context implements Serializable{

	/**项目/工程id**/
	private Long proId;

	/**job id 类似节点Id **/
	private Long jobId;

	public Long getProId()
	{
		return proId;
	}

	public void setProId(Long proId)
	{
		this.proId = proId;
	}

	public Long getJobId()
	{
		return jobId;
	}

	public void setJobId(Long jobId)
	{
		this.jobId = jobId;
	}
}
