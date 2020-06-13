package com.future.data.structure.map;

public interface IMap<K, V> {
    void add(K k, V v);
    boolean isEmpty();
    int size();
    V remove(K k);
    boolean isContainsKey(K k);
    V get(K k);
    void set(K k, V newVal);
}
