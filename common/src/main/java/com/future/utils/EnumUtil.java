package com.future.utils;

public class EnumUtil {
	
	public static <EnumModel> String toString(EnumModel model) {
		if(model != null) {
			return model.toString();
		}
		return null;
	}
	
	public static <T extends Enum<T>> T valueOf(Class<T> enumType, String name) {
		if(name != null && !name.isEmpty()) {
			return Enum.valueOf(enumType, name);
		}
		return null;
	}
	
}
