package com.future.data.structure.ThreadQuestion;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: Cock a doodle doo
 */
public class Volatitle3 {
    /**
     * @author: Cock a doodle doo
     * <p>
     * 下面的这段代码有问题，为什么会出现a = 1 ,b = 100的情况？
     */
    public int a = 1;
    public int b = 2;

    final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();//读写锁
    final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();//读锁
    final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();//写锁

    public void increase() {
        try{
            writeLock.lock();
            a = 100;
            b = a;
        }finally {
            writeLock.unlock();
        }

    }

    public void print(Volatitle3 v3){
        try {
            readLock.lock();
            System.out.println(v3.b);
            System.out.println(v3.a + "===" + v3.a + "###" + v3.b);
        }finally {
            readLock.unlock();
        }
    }

    private static final int THREAD_NUM = 5;

    public static void main(String[] args) {
        for (; ; ) {
            final Volatitle3 v3 = new Volatitle3();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    v3.increase();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    v3.print(v3);
                }
            }).start();
        }
    }
}
