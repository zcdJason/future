package com.future.protocol;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NodeStrategyProtocol<ST> extends NodeProtocol
{
	private static final long serialVersionUID = 865044173830123541L;
	private ST st;
}
