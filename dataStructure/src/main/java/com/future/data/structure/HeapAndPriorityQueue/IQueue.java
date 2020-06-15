package com.future.data.structure.HeapAndPriorityQueue;

public interface IQueue<E> {
    //入队
    void enqueue(E e);
    //出队
    E dequeue();
    //获取队首元素
    E getFont();
    //获取队列长度
    int getSize();
    //队列空判断
    boolean isEmpty();
}
