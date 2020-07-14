package com.future.data.structure.compationSorting;

/**
 * @author: Cock a doodle doo
 * 冒泡排序
 * 思想：从头遍历，保存最大/最小的元素，挨着比较元素，
 */
public class BubbleSort<E extends Comparable<E>> {

    //5,8,3,2,11
    //
    public void sort(E[] input, ComparableMy<E> cp) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j ++) {
                //当前最小和之前的有序数组依次进行比较，满足条件则进行交互
                if (cp.compare(input[i], input[j])) {
                    swap(i, j, input);//交互比较值
                }
            }
        }
    }

    public void swap(int j, int i, E[] input) {
        E t = input[j];
        input[j] = input[i];
        input[i] = t;
    }

    public static void main(String[] args) {
        Integer[] input = {5, 8, 3, 2, 11};
        BubbleSort s = new BubbleSort();
        s.sort(input, new ComparableMy<Integer>() {
            @Override
            public boolean compare(Integer a, Integer b) {
                return a > b;
            }
        });
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
        System.out.println();
    }
}
