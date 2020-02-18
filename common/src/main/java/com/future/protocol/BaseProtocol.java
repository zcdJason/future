package com.future.protocol;

import lombok.Data;

@Data
public class BaseProtocol implements Protocol
{
	private static final long serialVersionUID = 2761497027037000302L;

	/**上下文*/
	private Context context;

	/**处理组件类型*/
	private DealType dealType;

	/** 执行引擎 */
	private ExecEngine execEngine;

	/**节点类型 */
	private String nodeType;
}
