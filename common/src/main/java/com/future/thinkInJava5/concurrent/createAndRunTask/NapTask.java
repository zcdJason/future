package com.future.thinkInJava5.concurrent.createAndRunTask;

import com.future.thinkInJava5.onjava.Nap;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/NapTask.java
public class NapTask implements Runnable {
    final int id;
    public NapTask(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        new Nap(0.1);// Seconds
        System.out.println(this + " "+
            Thread.currentThread().getName());
    }
    @Override
    public String toString() {
        return"NapTask[" + id + "]";
    }
}

