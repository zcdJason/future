package com.future.data.structure.linearStructure.linkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    @Test
    public void add() {
        MyLinkedList<Integer> ls = new MyLinkedList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        System.out.println(ls);
        System.out.println(ls.contains(98));
    }
}