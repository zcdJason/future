package com.future.protocol;

import lombok.Data;

import java.io.Serializable;

@Data
public class Context implements Serializable{

	private static final long serialVersionUID = -1887837889827287211L;
	/**项目/工程id**/
	private long projectId;

	/**流id*/
	private long flowId;

	/**任务id**/
	private long jobId;

	/**当前节点id */
	private long nodeId;

	/**上一个节点id */
	private long previousNodeId;

	/**下一个节点id */
	private long NextNodeId;
}
