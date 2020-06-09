package com.future.data.structure.linearStructure.queue;


import java.util.Arrays;

/**
 * 浪费一个空间
 * @param <E>
 */
public class MyLoopQueue<E> implements IQueue<E> {
    E[] data;
    //队首索引
    int font;
    //队尾索引
    int tail;
    //队元素个数
    int size;

    public MyLoopQueue() {
        this(4);
    }

    public MyLoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
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

        E[] newData = (E[]) new Object[capacity + 1];
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
        return (tail + 1) % data.length == font;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        //定义队首等于队尾则为空队列
        return font == tail;
    }

    @Override
    public String toString() {
        return "MyLoopQueue{" +
                "data=" + Arrays.toString(data) +
                ", font=" + font +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
