package com.future.data.structure.linearStructure.queue;

import org.junit.Test;

public class MyLoop2QueueTest {

    @Test
    public void testAll() {
        MyLoop2Queue<Integer> loopQueue = new MyLoop2Queue<>();
        loopQueue.enqueue(1);
        loopQueue.enqueue(2);
        loopQueue.enqueue(3);
        loopQueue.enqueue(4);
        System.out.println(loopQueue);
        loopQueue.enqueue(5);
        loopQueue.enqueue(6);
        System.out.println(loopQueue);
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        System.out.println(loopQueue);
        loopQueue.enqueue(7);
        loopQueue.enqueue(8);
        loopQueue.enqueue(9);
        loopQueue.enqueue(9);
        loopQueue.enqueue(9);
        loopQueue.enqueue(9);
        loopQueue.enqueue(9);
        loopQueue.enqueue(9);
        loopQueue.enqueue(9);
        loopQueue.enqueue(9);
        loopQueue.dequeue();
        System.out.println(loopQueue);
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.enqueue(100);
        loopQueue.dequeue();
        loopQueue.enqueue(100);
        loopQueue.enqueue(100);
        loopQueue.enqueue(100);
        System.out.println(loopQueue);
    }
}