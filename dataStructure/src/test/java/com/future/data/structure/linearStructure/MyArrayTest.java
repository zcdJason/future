package com.future.data.structure.linearStructure;


import org.junit.Test;

public class MyArrayTest {
    @Test
    public void testArray(){
//        MyArray<Integer> intArray = new MyArray<Integer>();
//        intArray.addFirst(10);
//        intArray.addFirst(12);
//        intArray.addLast(100);
//        intArray.addLast(101);
//        System.out.println(intArray.size);
//        System.out.println(intArray.get(0));
//        System.out.println(intArray);
//        System.out.println(intArray.contains(100));

        MyArray<Student> sArray = new MyArray<>();
        Student s1 = new Student();
        s1.setAge(10);
        s1.setName("tiger1");

        Student s2 = new Student();
        s2.setAge(20);
        s2.setName("tiger2");

        Student s3 = new Student();
        s3.setAge(30);
        s3.setName("tiger3");

        sArray.addLast(s1);
        sArray.addLast(s2);
        sArray.addFirst(s3);
        System.out.println(sArray);
    }

}