package com.future;

/**
 * @author Cock-a-doodle-doo!
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1); // 暂停1毫秒
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");
        System.out.println(t.isInterrupted());
    }
}
