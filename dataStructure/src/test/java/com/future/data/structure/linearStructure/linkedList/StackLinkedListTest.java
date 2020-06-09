package com.future.data.structure.linearStructure.linkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackLinkedListTest {

    @Test
    public void push() {
        StackLinkedList<Integer> s = new StackLinkedList();
        s.push(5);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        System.out.println(s);
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        System.out.println(s);
    }
}