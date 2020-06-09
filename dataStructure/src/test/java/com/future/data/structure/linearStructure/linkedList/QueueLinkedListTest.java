package com.future.data.structure.linearStructure.linkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueLinkedListTest {

    @Test
    public void enqueue() {
        QueueLinkedList<Integer> tt = new QueueLinkedList();
        tt.enqueue(5);
        tt.enqueue(4);
        tt.enqueue(3);
        tt.enqueue(2);
        tt.enqueue(1);
        System.out.println(tt);
        tt.dequeue();
        tt.dequeue();
        tt.dequeue();
        tt.dequeue();
        System.out.println(tt);
    }
}