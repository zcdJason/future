package com.future.azkaban.plugin;


public class BaseDataProtocol extends BaseProtocol{

	/** 输出**/
	private DataBlock in;
	
	/** 输出**/
	private DataBlock out;

	public DataBlock getIn() {
		return in;
	}

	public void setIn(DataBlock in) {
		this.in = in;
	}

	public DataBlock getOut() {
		return out;
	}

	public void setOut(DataBlock out) {
		this.out = out;
	}
	
}
