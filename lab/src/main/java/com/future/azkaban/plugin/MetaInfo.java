package com.future.azkaban.plugin;


import java.io.Serializable;
import java.util.List;

public class MetaInfo implements Serializable{

	private List<SchemaItem> schemaItemList;

	public List<SchemaItem> getSchemaItemList() {
		return schemaItemList;
	}

	public void setSchemaItemList(List<SchemaItem> schemaItemList) {
		this.schemaItemList = schemaItemList;
	}
}
