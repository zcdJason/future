package com.future.data.structure.nonlinearStructure.segmentTree;

import java.util.Arrays;

/**
 * 线段树不是一颗完全二叉树，这里把它看作为一颗满二叉树，没有的地方用空填充。
 * @param <E>
 */
public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger){
        this.merger = merger;
        data = (E[])new Object[arr.length];
        for(int i = 0 ; i < arr.length; i++){
            data[i] = arr[i];
        }

        tree = (E[])new Object[4 * arr.length];
        buildSegmentTree(0, 0, arr.length -1);
    }

    private void buildSegmentTree(int treeIndex, int left, int right){
        if(left == right){
            tree[treeIndex] = data[left];
            return;
        }
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);

        //int mid = (left + right)/2;//可能导致整形溢出，因此替换写法
        int mid = left + (right - left) / 2;
        buildSegmentTree(leftIndex, left, mid);
        buildSegmentTree(rightIndex, mid + 1, right);

        tree[treeIndex] = merger.merge(tree[leftIndex], tree[rightIndex]);
    }

    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("index  illegal");
        return data[index];
    }


    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2* index + 2;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0 ; i < tree.length ; i ++){
            if(tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if(i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
