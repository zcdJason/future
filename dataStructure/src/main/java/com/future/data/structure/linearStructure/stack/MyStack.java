package com.future.data.structure.linearStructure.stack;

import com.future.data.structure.linearStructure.MyDynamicArray;

public class MyStack<E> implements IStack<E> {

    MyDynamicArray<E> stack;

    MyStack(int capacity)
    {
        stack = new MyDynamicArray<>(capacity);
    }

    MyStack()
    {
        stack = new MyDynamicArray<>();
    }


    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void push(E e) {
        stack.addLast(e);
    }

    @Override
    public E pop() {
        return stack.removeLast();
    }

    @Override
    public int getSize() {
        return stack.size();
    }

    @Override
    public E peek() {
        return stack.getLast();
    }

    public int getCapacity()
    {
        return stack.capacity();
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "stack=" + stack +
                '}';
    }
}
