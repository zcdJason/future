package com.future.data.structure.linearStructure;


import java.util.ArrayList;

public interface LinearStructure<E> {
    void add(E e, int index);

    E remove(int index);

    int size();

    int capacity();

    boolean isEmpty();

    E get(int index);

    boolean contains(E e);
}
