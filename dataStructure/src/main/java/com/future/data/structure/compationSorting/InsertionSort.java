package com.future.data.structure.compationSorting;

/**
 * @author: Cock a doodle doo
 * <p>
 * 插入排序算法
 * 思想：将排序队列分为有序的和无序的
 * 1.从无序的队列中选出一个插入到有序的队列中，如果值符合比较器规则就进行交互
 *
 * 插入排序对部分有序的数组十分高效，也适合小规模的数组。
 * 基于大规模的乱序 插入排序很慢，因为它只是交换相邻的元素，慢慢的从右向左移动。
 */
public class InsertionSort<E extends Comparable<E>> {
    //5,8,3,2,11
    //
    public void sort(E[] input, ComparableMy<E> cp) {
        int len = input.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i; //记录一个最小值索引
            for (int j = i - 1; j >= 0; j--) {//有序数组
                //当前最小和之前的有序数组依次进行比较，满足条件则进行交互
                if (cp.compare(input[minIndex], input[j])) {
                    swap(minIndex, j, input);//交互比较值
                    minIndex = j; //维护最小索引
                }
            }
        }
    }

    //8, 9, 12, 3, 10 来自算法4的代码
    public void sort2(E[] input, ComparableMy<E> cp) {
        int len = input.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0 && cp.compare(input[j], input[j-1]); j--) {//有序数组
                //当前最小和之前的有序数组依次进行比较，满足条件则进行交互
                swap(j, j-1, input);//交互比较值
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
        StdRandom.shuffle(input);
//        print(input);

        InsertionSort s = new InsertionSort();
        s.sort2(input, new ComparableMy<Integer>() {
            @Override
            public boolean compare(Integer a, Integer b) {
                return a < b;
            }
        });
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
        System.out.println();
    }

    public static void print(Integer[] input){
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

}
