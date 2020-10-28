package com.future.thinkInJava5.concurrent.createAndRunTask;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/CountingTask.java

import java.util.concurrent.*;

public class CountingTask implements Callable<Integer> {

    final int id;

    public CountingTask(int id) {
        this.id = id;
    }

    @Override
    public Integer call() {//没有可变的共享状态
        Integer val = 0;
        for (int i = 0; i < 100; i++) {
            val++;
        }
        System.out.println(id + " " +
            Thread.currentThread().getName() + " " + val);
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return val;
    }
}

