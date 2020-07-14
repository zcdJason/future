package com.future.data.structure.compationSorting;

/**
 * @author: Cock a doodle doo
 * 快速排序（单路快排，双路排序，三路排序）
 * 随机快速排序
 */
public class QuickSort<E extends Comparable<E>> {
    public void swap(int i, int j, E[] arr) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void sort(int left, int right, E[] arr){
        int pivot = partition(left, right, arr);//对数据进行分区操作
        //递归对左和右进行快速排序
        if(pivot > left)
            sort(left, pivot-1, arr);
        if(pivot < right)
            sort(pivot+1, right, arr);
    }

    private int partition(int start, int end, E[] arr) {
        int pivot = (int)(start + Math.random()* (end - start+ 1));
return 0;
    }
}
