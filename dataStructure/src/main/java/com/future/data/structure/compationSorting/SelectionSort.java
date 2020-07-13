package com.future.data.structure.compationSorting;

/**
 * @author: Cock a doodle doo
 * 选择排序算法
 */
public class SelectionSort<E extends Comparable<E>>{
    public  void sort(E[] input , ComparableMy<E> cp){
        for(int j=0; j< input.length; j++){
            int minIndex = j; //定义一个最小值索引
            for(int i= j+1; i< input.length; i++){
                if(cp.compare(input[i], input[minIndex])){
                    minIndex = i; //找到一个最小值索引
                }
            }
            //如果最小索引有变化，则交互两个元素
            if(j != minIndex){
               swap(j, minIndex, input);
            }
        }
    }

    public void swap(int j,  int minIndex, E[]input){
        E t = input[j];
        input[j] = input[minIndex];
        input[minIndex] = t;
    }



    public static  void main(String[] args) {
        Integer[] a= new Integer[]{8,9,12,3,10};
        SelectionSort s = new SelectionSort();
        s.sort(a, new ComparableMy<Integer>() {
            @Override
            public boolean compare(Integer a, Integer b) {
                return a < b;
            }
        });
        for(int i=0; i< a.length; i++){
            System.out.println(a[i]);
        }

    }
}
