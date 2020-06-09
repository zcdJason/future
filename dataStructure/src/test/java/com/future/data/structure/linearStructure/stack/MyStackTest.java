package com.future.data.structure.linearStructure.stack;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyStackTest {

    MyStack<Integer> stack;
    @Before
    public void setUp() throws Exception {
        stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isEmpty() {
        assertFalse(stack.isEmpty());
    }

    @Test
    public void push() {
        stack.push(100);
        stack.push(101);
        stack.push(102);
        stack.push(103);
        System.out.println(stack);
    }

    @Test
    public void pop() {
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
    }

    @Test
    public void getSize() {
        System.out.println(stack.getSize());
    }

    @Test
    public void peek() {
        System.out.println(stack.peek());
    }

    @Test
    public void getCapacity() {
        stack.push(100);
        stack.push(101);
        stack.push(102);
        stack.push(103);
        System.out.println(stack.getCapacity());
        System.out.println(stack);
    }

    @Override
    public String toString() {
        return "MyStackTest{" +
                "stack=" + stack +
                '}';
    }
}