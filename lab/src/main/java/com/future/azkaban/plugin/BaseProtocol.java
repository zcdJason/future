package com.future.azkaban.plugin;


public class BaseProtocol implements Protocol{

	private static final long serialVersionUID = 1285158519163877805L;

	private Context ctx;

	private ProtocolType protocolType;

	public ProtocolType getProtocolType() {
		return protocolType;
	}

	public void setProtocolType(ProtocolType protocolType) {
		this.protocolType = protocolType;
	}

	public Context getCtx() {
		return ctx;
	}

	public void setCtx(Context ctx) {
		this.ctx = ctx;
	}
	
}
