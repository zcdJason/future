package com.future.data.structure.ThreadQuestion;

import java.util.Map;

/**
 * @author: Cock a doodle doo
 */
public class Solution {
    static class T extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        T t1 = new T();
        T t2 = new T();
        t1.start();
        //Thread.activeCount()只是计算当前线程的线程组里面有多少活跃线程，而不是所有的活跃线程
        System.out.println("当前活跃线程数量:"+Thread.activeCount());
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        System.out.println("当前线程组的名称:"+group.getName());
        Thread[] list1 = new Thread[group.activeCount()];
        group.enumerate(list1);
        for (Thread thread:list1){
            System.out.println(thread.getName());
        }
        ThreadGroup groupParent = group.getParent();
        System.out.println("当前线程组的名称:"+groupParent.getName());
        Thread[] list2 = new Thread[groupParent.activeCount()];
        groupParent.enumerate(list2);
        for (Thread thread:list2){
            System.out.println(thread.getName());
        }
        t2.start();


        System.out.println(Thread.activeCount());
    }
}
