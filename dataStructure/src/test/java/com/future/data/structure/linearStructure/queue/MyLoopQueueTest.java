package com.future.data.structure.linearStructure.queue;

import com.future.data.structure.linearStructure.linkedList.ILinkedList;
import com.future.data.structure.linearStructure.linkedList.MyLinkedList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class MyLoopQueueTest {

    @Test
    public void test() {
        MyLoopQueue<Integer> loopQueue = new MyLoopQueue<>();
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

    @Test
    public void Test2(){
        List<Integer> s = new LinkedList<>();
        s.add(3);
        System.out.println(s);

        ILinkedList<Integer> t = new MyLinkedList<>();
        t.add(1);
        t.add(2);
        t.add(3);
        System.out.println(t);
        System.out.println(t.remove(2));
        System.out.println(t);
    }
}