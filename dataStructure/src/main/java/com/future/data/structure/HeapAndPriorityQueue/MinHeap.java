package com.future.data.structure.HeapAndPriorityQueue;

public class MinHeap<E extends Comparable<E>> {
    MyArray<E> data;

    @Override
    public String toString() {
        return "MaxHeap{" +
                "data=" + data +
                '}';
    }

    public void shangfu(int k) {
        if (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public void xiaceng(int k) {
        //下沉条件;当一个节点没有子节点的时候就需要结束循环
        //即当左孩子的索引小于数组长度的时候，满足循环条件
        while (leftChild(k) < data.size()) {
            int j = leftChild(k);
            //判断一下是否有右孩子,有则比较左右孩子的大小来决定和谁交换
            if (j + 1 < data.size() && data.get(j).compareTo(data.get(j + 1)) < 0) {
                j = rightChild(k);// j++
            }
            //在比较 k位置的和 左右孩子的谁大
            if (data.get(k).compareTo(data.get(j)) > 0) {
                //本身就大于左右孩子最大的，则推出循环
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    //build max heap
    public MinHeap(int capacity) {
        data = new MyArray<>(capacity);
    }

    public MinHeap() {
        data = new MyArray<>();
    }

    //heapify array;从最后一个非叶子节点开始执行下沉操作；这样第一时间就抛弃了一半的节点
    public MinHeap(E[] input) {
        data = new MyArray<>(input);
        if (data.size() > 1) {
            for (int i = parent(data.size() - 1); i >= 0; i--) {
                shiftDown(i);
            }
        }
    }

    public void heapify(){
        data = new MyArray<>();
        if (data.size() > 1) {
            for (int i = parent(data.size() - 1); i >= 0; i--) {
                shiftDown(i);
            }
        }
    }

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树的父索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index 0 does's not have parents");
        }
        return (index - 1) / 2;
    }

    //返回完全二叉树的左孩子索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //返回完全二叉树的右孩子索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.size() - 1);
    }

    //上浮操作
    private void siftUp(int i) {
        //如果父数据和插入节点的数据比较 小 则交换，维护堆特性
        while (i > 0 && data.get(parent(i)).compareTo(data.get(i)) > 0) {
            data.swap(i, parent(i));
            i = parent(i);
        }
    }

    private void conditionShiftDown(int k, int tail) {
        shiftDown2(k, tail);
    }

    //下沉操作
    private void shiftDown2(int k, int tail) {
        //循环的条件是左孩子小于个数
        while (leftChild(k) < data.size()) {
            int j = leftChild(k);
            //j+1 即为右孩子，如果右孩子大于左孩子，则交换右孩子索引
            if (j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) < 0) {
                j = rightChild(k);
            }
            //如果输入的节点大于 左右孩子最大的节点则不交换，推出循环
            if (data.get(k).compareTo(data.get(j)) < 0)
                break;

            if(j >= tail){
                break;
            }
            data.swap(k, j);
            //继续比较下一个
            k = j;
        }
    }

    //下沉操作
    private void shiftDown(int k) {
        //循环的条件是左孩子小于个数
        while (leftChild(k) < data.size()) {
            int j = leftChild(k);
            //j+1 即为右孩子，如果右孩子大于左孩子，则交换右孩子索引
            if (j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) < 0) {
                j = rightChild(k);
            }
            //如果输入的节点大于 左右孩子最大的节点则不交换，推出循环
            if (data.get(k).compareTo(data.get(j)) < 0) {
                break;
            }
            data.swap(k, j);
            //继续比较下一个
            k = j;
        }
    }


    //找出最大堆的最大值，即为第一个根节点。
    public E getMax() {
        if (data.size() == 0) {
            throw new IllegalArgumentException("heap size is empty");
        }
        return data.get(0);
    }

    public E extractMax() {
        //switch the last  and root
        E ret = getMax();
        int lastIndex = data.size() - 1;
        data.swap(0, lastIndex);
        data.removeLast();
        shiftDown(0);

        return ret;
    }

    //remove the element from root
    public E remove() {
        return extractMax();
    }

    public E replaceElement(E e) {
        E ret = getMax();
        data.set(0, e);
        shiftDown(0);
        return ret;
    }

    public MyArray order(E[] arr) {
        //构建
        System.out.println(data);
        for (int tail = arr.length - 1; tail > 0; tail--) {
            //交换
            data.swap(tail, 0);
            //下沉调整
            conditionShiftDown(0, tail);
        }
        return data;
    }
}
