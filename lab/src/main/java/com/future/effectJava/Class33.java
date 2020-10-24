package com.future.effectJava;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Cock a doodle doo
 */
public class Class33 {
    private Map<Class<?>, Object> map = new HashMap<>();

    public <T> void put(Class<T> cls, T instance) {
        map.put(cls, instance);
    }

    public <T> T get(Class<T> type) {
        return type.cast(map.get(type));
    }

    public static void main(String[] args) {
        Class33 c3 = new Class33();
        c3.put(String.class, "java");
        c3.put(Integer.class, 10);
        c3.put(Class.class, Class33.class);

        System.out.println(c3.get(String.class));
        System.out.println(c3.get(Integer.class));
        System.out.println(c3.get(Class.class));
    }
}
