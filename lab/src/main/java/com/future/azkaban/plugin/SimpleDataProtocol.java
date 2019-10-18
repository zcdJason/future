package com.future.azkaban.plugin;

public class SimpleDataProtocol<ST> extends BaseDataProtocol{

	private ST st;

	public ST getSt() {
		return st;
	}

	public void setSt(ST st) {
		this.st = st;
	}

}
