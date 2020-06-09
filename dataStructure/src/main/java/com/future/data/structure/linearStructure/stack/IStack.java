package com.future.data.structure.linearStructure.stack;

public interface IStack<E> {
    boolean isEmpty();
    void push(E e);
    E pop();
    int getSize();
    E peek();
}
