package com.future.data.structure.compationSorting;

/**
 * @author: Cock a doodle doo
 * 快速排序（单路快排，双路排序，三路排序）
 * 随机快速排序
 * 快速排序的特点
 * 1-原地排序（只需要一个很小对辅助栈）
 * 2-长度为N的数组排序所需要的时间和NlgN成正比
 * 3-快速排序的内循环比大多数排序算法都要小
 *
 * 缺点：
 * 脆弱，表现为需要很小心的实现，否则会导致性能在平方级别。
 *
 * 分治排序算法
 */
public class QuickSort<E extends Comparable<E>> {
    public void swap(int i, int j, E[] arr) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

//    public void sort(int left, int right, E[] arr) {
//        int pivot = partition(left, right, arr);//对数据进行分区操作
//        //递归对左和右进行快速排序
//        if (pivot > left)
//            sort(left, pivot - 1, arr);
//        if (pivot < right)
//            sort(pivot + 1, right, arr);
//    }
//
//    private int partition(int start, int end, E[] arr) {
//        int pivot = (int) (start + Math.random() * (end - start + 1));
//        return 0;
//    }
}
