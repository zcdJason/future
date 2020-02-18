package com.future.protocol;


import com.future.dataModel.DataSet;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NodeProtocol extends BaseProtocol
{
	private static final long serialVersionUID = -237741646598982996L;
	/** 输出**/
	private DataSet in;
	
	/** 输出**/
	private DataSet out;
	
}
