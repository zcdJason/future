package com.future.data.structure.compationSorting;

import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.bytecode.ConstPool;
import org.apache.ibatis.javassist.bytecode.analysis.Executor;

/**
 * @author: Cock a doodle doo
 *
 * 分治思想的典型应用
 *
 * 归并排序最吸引人的性质是它能够保证将任意长度的N的数组排序所需要的时间和NlogN成正比
 * 主要缺点：它所需要的额外空间和N成正比
 *
 *
 * 对归并排序的优化
 * 1-对小规模的数组使用插入排序
 * 2 对数组是否有序进行提前判断  如a[mid]  <=  a[mid+1] 我们认为数组已经有序了，就跳过merge方法
 * 3 不将元素复制到辅助数组
 *
 * 归并排序和shell排序对差别是常数级别之内
 */
public class MergeSort extends Example {

    private static Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length]; //利用辅助数组
        sort(a, 0, a.length - 1);
    }

    public void sort(Comparable[] a, int lower, int high) {
        if (high <= lower)
            return;
        int mid = lower + (high - lower) / 2;
        sort(a, lower, mid);//左边排序
        sort(a, mid + 1, high); //右边排序
        merge2(a, lower, mid, high); //归并
    }



    /**
     *                           a[0....15]
     *                       /               \
     *               a[0...7]                 a[8...15]
     *                /     \                /          \
     *         a[0..3]    a[4..7]      a[8..11]          a[12..15]
     *          /  \      /   \          /    \              /    \
     * a[0..1] a[2..3] a[4..5] a[6..7] a[8..9] a[10..11] a[12..13] a[14..15]
     *   自底向上的归并排序比较适合用链表组织的数据
     * @param a
     */
    public void sort2(Comparable[] a)
    { //进行lgN次两两归并
        int N = a.length;
        aux = new Comparable[a.length];
        for(int sz = 1; sz < N; sz = 2*sz)//sz子数组大小
            for(int lower = 0; lower < N-sz; lower += 2*sz) //子数组索引
                //merge(0, 0, 1),merge(2,2,3) 及最后一排，接着合并倒数第二层....
                merge(a, lower, lower+sz -1, Math.min(lower + 2*sz -1, N-1));

    }

    //原地归并，利用辅助数组，自顶向下的归并排序
    public static void merge(Comparable[] a, int lower, int mid, int high) {
        //将a[lower, mid]    a[mid+1, high]归并
        int i = lower, j = mid + 1;
        for (int k = lower; k <= high; k++)
            aux[k] = a[k]; //将a[lower, high]复制到aux[lower, high]

        //i=0； j = 1
        for (int k = lower; k <= high; k++) {
            if (i > mid) //左半边用完，取右半边元素
                a[k] = aux[j++];
            else if (j > high) //右半边用完，取左边元素
                a[k] = aux[i++];
            else if (less(aux[j], aux[i])) //右边小于左边 取右边
                a[k] = aux[j++];
            else
                a[k] = aux[i++]; //右边大于左边 取左边
        }
    }

    //对小规模数据使用插入排序
    public static void merge2(Comparable[] a, int lower, int mid, int high) {
        int i = lower, j = mid + 1;
        //优化归并排序，添加判断条件
        if (a[mid].compareTo(a[j]) <= 0)
            return;
        ;
        int len = a.length;
        for (int k = 0; k < len; k++) {
            aux[k] = a[k];//复制数组
        }
        for (int k = lower; k <= high; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > high)
                a[k] = aux[i++];
            else if (less(aux[i], aux[j]))
                a[k] = a[i++];
            else
                a[k] = a[j++];
        }
    }

    public static void main(String[] args) {
        Double[] a = {3.0, 8.0, 2.0, 11.0, 18.0, 9.0};
        int i = 0;
        StdOut.print(a[i++]);
        MergeSort s = new MergeSort();
//        s.sort(a);
        s.sort2(a);
        Shell.show(a);
    }
}













