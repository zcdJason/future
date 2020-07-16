package com.future.data.structure.compationSorting;

/**
 * @author: Cock a doodle doo
 * <p>
 * 三路快排使得三向切分的快速排序比归并排序和其它排序算法在 包含重复元素很多的实际应用中更快
 */
public class Quick3 extends Example {

    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public void sort(Comparable[] a, int lo, int hi) {
        int M = 15;//如果待排序的数组在(5~15之间)任意值，使用插入排序效果更好
        if (hi <= lo + M) {
            new Insertion().sort(a);
            return;
        }
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];
        //三路快速排序交换比较多，但是元素相等的情况只是移动索引而已，因此对于部分相等的情况，效果要好些
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) swap(a, lt++, i++); //a[i] < v  a[lt] a[i] exchange     lt and i  + 1;
            else if (cmp > 0) swap(a, i, gt--); //a[i] > v a[gt] a[i] exchange   gt  - 1;
            else i++;  //a[i] == v    i + 1;
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }


    public static void main(String[] args) {
//        Double[] a = {3.0, 8.0, 2.0, 11.0, 18.0, 9.0};
        Double[] a = {8.0, 8.0, 8.0, 8.0, 8.0, 8.0};
        Quick3 q = new Quick3();
        q.sort(a);
        q.show(a);
    }
}
