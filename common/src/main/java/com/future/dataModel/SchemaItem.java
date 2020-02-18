package com.future.dataModel;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class SchemaItem implements Serializable ,Comparable{
	private static final long serialVersionUID = -461998534265110395L;
	/** 名称 */
	private String name;
	/** 类型 */
	private String type;
	/** 描述 */
	private String desc;

	/** 是否分区字段 */
	private Boolean isPartition;

	/** 扩展的tag标识 */
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
