package com.future;

/**
 * @author Cock-a-doodle-doo!
 */
public class MyThread extends Thread {
    public void run() {
        int n = 0;
        while (! isInterrupted()) {
            n ++;
            System.out.println(n + " hello!");
        }
    }
}
