package com.future.data.structure.HeapAndPriorityQueue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PriorityQueueTest {

    @Test
    public void test() {

//        PriorityQueue<Integer> p1 = new PriorityQueue<>();
//        p1.enqueue(2);
//        p1.enqueue(3);
//        p1.enqueue(5);
//        p1.enqueue(10);
//        System.out.println(p1);
//
//        System.out.println(p1.dequeue());
//        System.out.println(p1.dequeue());
//        System.out.println(p1.dequeue());
//        System.out.println(p1.dequeue());
        ArrayList<String> list = new ArrayList<>(2); list.add("guan");
        list.add("bao");
        String[] array = list.toArray(new String[0]);

        Integer[] input = new Integer[]{10,7,5,3,2,4};
        MinHeap<Integer> heap = new MinHeap<>(input);
        MaxHeap<Integer> heap2 = new MaxHeap<>(input);
        MyArray res = heap.order(input);
        MyArray res2 = heap2.order(input);
        System.out.println(res);
        System.out.println(res2);
    }
}