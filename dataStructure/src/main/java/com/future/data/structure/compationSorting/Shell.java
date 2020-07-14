package com.future.data.structure.compationSorting;

/**
 * @author: Cock a doodle doo
 * 插入排序对部分有序的数组十分高效，也适合小规模的数组。
 * 基于大规模的乱序 插入排序很慢，因为它只是交换相邻的元素，慢慢的从右向左移动。
 * 思想：希尔排序为了加快速度对插入排序进行改进，交换不相邻的元素对数组进行局部排序，最终用插入排序将局部有序对数组排序；
 * 因为插入排序对局部有序对数据移动较少元素，从而提供速度
 *
 * 和选择排序以及插入排序形成对比的是，希尔排序也可以用于大型数组，它对任意排序对数组表现也很好
 * 对于中等大小对数组希尔排序的时间是可以接受的，它不需要额外的内存空间
 */
public class Shell extends Example {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ......
        while (h >= 1)
        {//将数组变为h有序
            for (int i = h; i < N; i++)
            {//将数组a[i]插入a[i-h], a[i-2*h], a[i-3*h]..之中
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    swap(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Double[] a = {3.0, 8.0, 2.0, 11.0, 18.0, 9.0};
        Shell s = new Shell();
        s.sort(a);
        Shell.show(a);
    }
}
