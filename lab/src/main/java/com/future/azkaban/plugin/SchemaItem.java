package com.future.azkaban.plugin;

import java.io.Serializable;
import java.util.Objects;

public class SchemaItem implements Serializable ,Comparable{
	private String name;
	private String type;
	private String desc;
	private Boolean isPartition;
	private String tag;

	public SchemaItem() {
	}

	public SchemaItem(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public SchemaItem(String name, String type, String desc, Boolean isPartition) {
		this.name = name;
		this.type = type;
		this.desc = desc;
		this.isPartition = isPartition;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Boolean getPartition() {
		return isPartition;
	}

	public void setPartition(Boolean partition) {
		isPartition = partition;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "SchemaItem{" +
				"name='" + name + '\'' +
				", type='" + type + '\'' +
				", desc='" + desc + '\'' +
				", isPartition=" + isPartition +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SchemaItem that = (SchemaItem) o;
		return Objects.equals(name, that.name) &&
				Objects.equals(type, that.type) &&
				Objects.equals(isPartition, that.isPartition);
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (type != null ? type.hashCode() : 0);
		return result;
	}

	@Override
	public int compareTo(Object o) {
		if (o == null || getClass() != o.getClass()) {
			return -1;
		}
		SchemaItem that = (SchemaItem) o;
		return (name+type).compareTo(that.getName()+that.getType());
	}
}
