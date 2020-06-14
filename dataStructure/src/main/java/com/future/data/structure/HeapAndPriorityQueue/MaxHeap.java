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

    private void shiftDown(int k){
        //循环的条件是左孩子小于个数
        while(leftChild(k) < data.size()){
            int j = leftChild(k);
            //j+1 即为右孩子，如果右孩子大于左孩子，则交换右孩子索引
            if(j + 1 < data.size() && data.get(j+1).compareTo(data.get(k)) > 0){
                j = leftChild(k);
            }
            //如果输入的节点大于 左右孩子最大的节点则不交换，推出循环
            if(data.get(k).compareTo(data.get(j)) > 0){
                break;
            }
            data.swap(k, j);
            //继续比较下一个
            k = j;
        }
    }


    //找出最大堆的最大值，即为第一个根节点。
    public E getMax(){
        if(data.size() == 0){
            throw new IllegalArgumentException("heap size is empty");
        }
        return data.get(0);
    }

    public E extractMax(){
        //switch the last  and root
        E  ret = getMax();
        int lastIndex = data.size() -1;
        data.swap(0, lastIndex);
        data.removeLast();
        shiftDown(0);

        return ret;
    }

    //remove the element from root
    public boolean remove(E e){
    return false;
    }

    public void replaeElement(){

    }

    public void heapfify(E[] e){

    }
}
