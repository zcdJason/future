package com.future.data.structure.HeapAndPriorityQueue;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityQueueTest {

    @Test
    public void test() {

        PriorityQueue<Integer> p1 = new PriorityQueue<>();
        p1.enqueue(2);
        p1.enqueue(3);
        p1.enqueue(5);
        p1.enqueue(10);
        System.out.println(p1);

        System.out.println(p1.dequeue());
        System.out.println(p1.dequeue());
        System.out.println(p1.dequeue());
        System.out.println(p1.dequeue());
    }
}