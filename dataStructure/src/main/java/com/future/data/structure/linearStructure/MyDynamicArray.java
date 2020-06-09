package com.future.data.structure.linearStructure;

import java.util.Arrays;

public class MyDynamicArray<E> implements LinearStructure<E> {

    E[] data;
    int size;

    public MyDynamicArray() {
        this(4);
    }

    public MyDynamicArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    @Override
    public void add(E e, int index) {
        if (size == data.length)
            resize(size * 2);

        if (index < 0 || index > data.length)
            throw new IllegalArgumentException("add failed, index out of array");

        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("get element failed, index illegal!");
    }

    public boolean addFirst(E e) {
        add(e, 0);
        return true;
    }

    public boolean addLast(E e) {
        add(e, size);
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int index) {
        return data[index];
    }

    public E getFirst() {
        return data[0];
    }

    public E getLast() {
        return data[size - 1];
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }


    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "data=" + Arrays.toString(data) +
                '}' + ", size=" + size;
    }
}
