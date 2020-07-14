package com.future.data.structure.compationSorting;

import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.bytecode.ConstPool;
import org.apache.ibatis.javassist.bytecode.analysis.Executor;

/**
 * @author: Cock a doodle doo
 * 归并排序最吸引人的性质是它能够保证将任意长度的N的数组排序所需要的时间和NlogN成正比
 * 主要缺点：它所需要的额外空间和N成正比
 */
public  class MergeSort extends Example {

    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length -1);
    }

    public void sort(Comparable[] a, int lower, int high){
        if(high <= lower)
            return;
        int mid = lower + (high - lower) /2;
        sort(a, lower, mid);
        sort(a, mid+1, high);
        merge(a, lower, mid, high);
    }

    //原地归并，利用辅助数组
    public static void merge(Comparable[] a, int lower, int mid, int high){
        //将a[lower, mid]    a[mid+1, high]归并
        int i = lower, j = mid + 1;
        Comparable[] aux = new Comparable[a.length];
        for(int k = lower; k<=high; k++)
            aux[k]  = a[k]; //将a[lower, high]复制到aux[lower, high]
        for(int k = lower; k<=high; k++){
            if(i > mid) //左半边用完，取右半边元素
                a[k] = aux[j++];
            else if(j > high) //右半边用完，取左边元素
                a[k] = aux[i++];
            else if(less(aux[j], aux[i])) //右边 小于左边 取右边
                a[k] = aux[j++];
            else
                a[k] = aux[i++]; //右边 大于左边 取左边
        }
    }

    public static void main(String[] args) {
        Double[] a = {3.0, 8.0, 2.0, 11.0, 18.0, 9.0};
        MergeSort s = new MergeSort();
        s.sort(a);
        Shell.show(a);
    }
}













