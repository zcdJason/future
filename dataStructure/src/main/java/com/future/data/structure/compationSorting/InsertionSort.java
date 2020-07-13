package com.future.data.structure.compationSorting;

/**
 * @author: Cock a doodle doo
 * <p>
 * 插入排序算法
 */
public class InsertionSort<E extends Comparable<E>> {
    //5,8,3,2,11
    //
    public void sort(E[] input, ComparableMy<E> cp) {
        for (int i = 0; i < input.length; i++) {
            int minIndex = i; //记录一个最小值索引
            for(int j = i-1; j >= 0; j--){//有序数组
                //当前最小和之前的有序数组依次进行比较，满足条件则进行交互
                if(cp.compare(input[minIndex], input[j])) {
                    swap(minIndex, j, input);
                    minIndex = j;
                }
            }
        }
    }

    public void swap(int j,  int i, E[]input){
        E t = input[j];
        input[j] = input[i];
        input[i] = t;
    }

    public static void main(String[] args) {
        Integer[] input = {5,8,3,2,11};
        InsertionSort s = new InsertionSort();
        s.sort(input, new ComparableMy<Integer>() {
            @Override
            public boolean compare(Integer a, Integer b) {
                return a > b;
            }
        });
        for(int i=0; i< input.length ; i++){
            System.out.println(input[i]);
        }
        System.out.println();
    }

}
