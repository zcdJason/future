package com.future.azkaban.plugin;

public class DataBlock implements Protocol{

	/** 文件类型 **/
    private FileType fileType;
	/** 数据存储系统 **/
    private StoreEngine storeEngine;
    /** 数据存储数据库**/
    private String database;
    /** 数据存储数据表**/
    private String table;
    /** 数据存储数据地址**/
    private String path;
    /** 数据块的元数据信息**/
    private MetaInfo metaInfo;

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	public StoreEngine getStoreEngine() {
		return storeEngine;
	}

	public void setStoreEngine(StoreEngine storeEngine) {
		this.storeEngine = storeEngine;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public MetaInfo getMetaInfo() {
		return metaInfo;
	}

	public void setMetaInfo(MetaInfo metaInfo) {
		this.metaInfo = metaInfo;
	}

	@Override
	public String toString() {
		return "DataBlock [fileType=" + fileType + ", storeEngine=" + storeEngine + ", database=" + database
				+ ", table=" + table + ", path=" + path + ", metaInfo=" + metaInfo + "]";
	}
    
}
