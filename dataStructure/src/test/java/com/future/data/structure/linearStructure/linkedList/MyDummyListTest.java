package com.future.data.structure.linearStructure.linkedList;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class MyDummyListTest {

    @Test
    public void add() {
//        List<Integer> res = new LinkedList<>();
        MyDummyList<Integer> myDummyList = new MyDummyList<>();
        myDummyList.add(1);
        myDummyList.add(2);
        myDummyList.add(3);
        myDummyList.add(4);
        System.out.println(myDummyList);
        System.out.println(myDummyList.getFirst());
        System.out.println(myDummyList.getLast());
        myDummyList.remove(3);
        System.out.println(myDummyList);
        System.out.println(myDummyList.contains(3));
    }
}