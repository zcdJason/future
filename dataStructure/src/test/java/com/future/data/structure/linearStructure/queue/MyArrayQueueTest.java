package com.future.data.structure.linearStructure.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayQueueTest {

    @Test
    public void testAll() {
        MyArrayQueue<Integer> res = new MyArrayQueue<>();
        res.enqueue(3);
        res.enqueue(4);
        res.enqueue(5);
        System.out.println(res);
        res.dequeue();
        res.dequeue();
        System.out.println(res);
        System.out.println(res.getFont());
    }

    @Test
    public void enqueue() {
            int[] s= new int[3];
        System.out.println(s.length);
    }

    @Test
    public void dequeue() {
    }

    @Test
    public void getFont() {
    }

    @Test
    public void getSize() {
    }

    @Test
    public void isEmpty() {
    }
}