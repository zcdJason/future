package com.future.data.structure.linearStructure;

import java.util.Arrays;
import java.util.Objects;

public class MyArray<E> implements LinearStructure<E>{

    E[] data;
    int size;

    public MyArray(){
        this(8);
    }

    public MyArray(int capacity)
    {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    @Override
    public void add(E e, int index) {
        if(size == data.length)
            throw new IllegalArgumentException("add failed, array is full!");
        if(index < 0 || index > data.length)
            throw new IllegalArgumentException("add failed, index out of array");

        for(int i = size -1; i >= index; i -- )
            data[i+1] = data[i];

        data[index] = e;
        size ++;
    }

    private void  checkIndex(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("get element failed, index illegal!");
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E ret = data[index];
        for(int i= index + 1; index < size; i ++)
        {
            data[i-1] = data[i];
        }
        size --;
        data[size] = null;
        return ret;
    }

    public boolean addFirst(E e){
        add(e, 0);
        return true;
    }

    public boolean addLast(E e){
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
        checkIndex(index);
        return data[index];
    }

    @Override
    public boolean contains(E e) {
        for(int i = 0 ; i < size; i++){
            if(data[i] == e){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "data=" + Arrays.toString(data) +
                '}' +  ", size=" + size;
    }
}
