package com.future.thinkInJava5.functionCode;

/**
 * @author Cock-a-doodle-doo!
 */
// functional/RunnableMethodReference.java

// 方法引用与 Runnable 接口的结合使用

class Go {
    static void go() {
        System.out.println("Go::go()");
    }
}

public class RunnableMethodReference {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                System.out.println("Anonymous");
            }
        }).start();

        new Thread(
            () -> System.out.println("lambda") //使用lambda表达式
        ).start();

        new Thread(Go::go).start(); //使用方法引用，因为它符合run的方法签名
    }
}

