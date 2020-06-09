package com.future.data.structure.linearStructure.queue;


import java.util.Arrays;

/**
 * 不浪费空间
 * @param <E>
 */
public class MyLoop2Queue<E> implements IQueue<E> {
    E[] data;
    //队首索引
    int font;
    //队尾索引
    int tail;
    //队元素个数
    int size;

    public MyLoop2Queue() {
        this(4);
    }

    public MyLoop2Queue(int capacity) {
        data = (E[]) new Object[capacity];
        font = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (isFull())
            resize(getCapacity()*2);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int capacity) {

        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(font + i) % data.length];
        }
        font = 0;
        tail = size;
        data = newData;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("cannot dequeue element, queue is empty");
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        E res = data[font];
        data[font] = null;
        font = (font + 1) % data.length;
        size--;
        return res;
    }

    @Override
    public E getFont() {
        return data[font];
    }

    @Override
    public int getSize() {
        return size;
    }

    private boolean isFull() {
        return size == getCapacity();
    }

    public int getCapacity() {
        return data.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "MyLoop2Queue{" +
                "data=" + Arrays.toString(data) +
                ", font=" + font +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
