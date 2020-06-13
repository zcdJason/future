package com.future.data.structure.HeapAndPriorityQueue;

public class MaxHeap<E extends Comparable<E>> {
    MyArray<E> data;

    //build max heap
    public MaxHeap(int capacity){
        data = new MyArray<>(capacity);
    }

    public int size(){
        return data.size();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    //返回完全二叉树的父索引
    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("index 0 does's not have parents");
        }
        return  (index -1 ) /2;
    }

    //返回完全二叉树的左孩子索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    //返回完全二叉树的右孩子索引
    private int rightChild(int index){
       return index * 2 + 2;
    }

    public void add(E e){
        data.addLast(e);
        siftUp(data.size() -1);
    }

    private void siftUp(int i){
        //如果父数据和插入节点的数据比较 小 则交换，维护堆特性
        while (i > 0 && data.get(parent(i)).compareTo(data.get(i)) < 0){
            data.swap(i, parent(i));
            i = parent(i);
        }
    }

    //找出最大堆的最大值，即为第一个根节点。
    public E getMax(){
        if(data.size() == 0){
            throw new IllegalArgumentException("heap size is empty");
        }
        return data.get(0);
    }

    public boolean remove(E e){

    }
}
