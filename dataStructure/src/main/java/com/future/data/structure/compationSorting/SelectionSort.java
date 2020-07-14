package com.future.data.structure.compationSorting;

/**
 * @author: Cock a doodle doo
 * 选择排序算法
 * 思想：
 * 1.循环排序队列，设置第一个基准索引
 * 2.从剩余的队列中选出符合比较器规则的元素，有则记录临时变量，直到变量剩余的所有元素
 * 3.进行比较交换元素。
 */
public class SelectionSort<E extends Comparable<E>> {
    public void sort(E[] input, ComparableMy<E> cp) {
        int len = input.length;
        for (int j = 0; j < len; j++) {
            int minIndex = j; //定义一个最小值索引
            for (int i = j + 1; i < len; i++) {//剩余数组中查找最小值
                if (cp.compare(input[i], input[minIndex])) {
                    minIndex = i; //找到一个最小值索引
                }
            }
            //如果最小索引有变化，则交互两个元素
            if (j != minIndex) {
                swap(j, minIndex, input);
            }
        }
    }

    public void swap(int j, int minIndex, E[] input) {
        E t = input[j];
        input[j] = input[minIndex];
        input[minIndex] = t;
    }


    public static void main(String[] args) {
        Integer[] a = new Integer[]{8, 9, 12, 3, 10};
        SelectionSort s = new SelectionSort();
        s.sort(a, new ComparableMy<Integer>() {
            @Override
            public boolean compare(Integer a, Integer b) {
                return a < b;
            }
        });
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}
