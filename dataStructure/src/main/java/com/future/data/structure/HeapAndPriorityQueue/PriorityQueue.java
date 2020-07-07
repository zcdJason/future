package com.future.data.structure.HeapAndPriorityQueue;

public class PriorityQueue<E extends Comparable<E>> implements IQueue<E> {
    //使用最大堆来实现优先队列
    MaxHeap<E> data;

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "data=" + data +
                '}';
    }

    public PriorityQueue(){
        data = new MaxHeap<E>();
    }

    @Override
    public void enqueue(E e) {
        data.add(e);
    }

    @Override
    public E dequeue() {
        return data.extractMax();
    }

    @Override
    public E getFont() {
        return data.getMax();
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    public E[] orderQueue(){
        return null;
    }
}
