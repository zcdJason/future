package com.future.data.structure.linearStructure.queue;

import com.future.data.structure.linearStructure.MyDynamicArray;

public class MyArrayQueue<E> implements IQueue<E>{

    //底层使用动态数组
    MyDynamicArray<E> data;

    public  MyArrayQueue(){
        data = new MyDynamicArray<>();
    }

    public MyArrayQueue(int capacity)
    {
        data = new MyDynamicArray<>(capacity);
    }

    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    @Override
    public E getFont() {
        return data.getFirst();
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public String toString() {
        return "MyArrayQueue{" +
                "data=" + data +
                '}';
    }
}
