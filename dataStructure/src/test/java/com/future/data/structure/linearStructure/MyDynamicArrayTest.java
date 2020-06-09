package com.future.data.structure.linearStructure;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyDynamicArrayTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testArray(){
        MyDynamicArray<Integer> intArray = new MyDynamicArray<Integer>();
        intArray.addFirst(10);
        intArray.addFirst(12);
        intArray.addLast(100);
        intArray.addLast(101);
        intArray.addLast(101);
        intArray.addLast(101);
        intArray.addLast(101);
        intArray.addLast(101);
        intArray.addLast(101);
        intArray.addLast(101);
        intArray.addLast(101);
        intArray.addLast(101);
        intArray.addLast(101);
        System.out.println(intArray.size);
        System.out.println(intArray.get(0));
        System.out.println(intArray);
        System.out.println(intArray.contains(100));
    }

    @Test
    public void testArrayMinus(){
        MyDynamicArray<Integer> intArray = new MyDynamicArray<Integer>();
        intArray.addFirst(10);
        intArray.addFirst(12);
        intArray.addLast(100);
        intArray.addLast(101);
        intArray.addLast(101);
        intArray.addLast(101);
        intArray.addLast(101);
        intArray.addLast(101);
        intArray.addLast(101);
        intArray.addLast(101);
        intArray.addLast(101);
        intArray.addLast(101);
        intArray.addLast(101);
        System.out.println(intArray.size);
        System.out.println(intArray.get(0));
        System.out.println(intArray);
        System.out.println(intArray.contains(100));

        intArray.remove(0);
        intArray.remove(0);
        intArray.remove(0);
        intArray.remove(0);
        intArray.remove(0);
        intArray.remove(0);
        intArray.remove(0);
        intArray.remove(0);
        intArray.remove(0);
        System.out.println(intArray);
    }
}