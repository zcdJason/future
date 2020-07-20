package com.future.data.structure;

import io.micrometer.core.instrument.util.JsonUtils;

import java.io.Serializable;

/**
 * @author: Cock a doodle doo
 */
public class OverLoadTest {
//     static void sayHello(long arg){
//        System.out.println("hello long");
//    }
//    static void sayHello(int arg){
//        System.out.println("hello int");
//    }
//    static void sayHello(Character arg){
//        System.out.println("hello Character");
//    }
//    static void sayHello(char arg){
//        System.out.println("hello char");
//    }
    static void sayHello(char ... arg){
        System.out.println("hello char ....");
    }

//    static void sayHello(Serializable arg){
//        System.out.println("hello Serializable");
//    }
//    static void sayHello(Object arg){
//        System.out.println("hello object");
//    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
