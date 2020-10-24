package com.future.data.structure.ThreadQuestion;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: Cock a doodle doo
 * <p>
 * 下面的这段代码有问题，为什么会出现a = 1 ,b = 100的情况？
 */
public class VolatileTest2 {
    public volatile int a = 1;
    public volatile int b = 2;
    final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();//读写锁
    final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();//读锁
    final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();//读锁

    public void increase(VolatileTest2 v2) {
        try {
            writeLock.lock();
            System.out.println("获取写锁：" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            v2.a = 100;
            v2.b = v2.a;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public void resume(VolatileTest2 v2) {
        try {
            writeLock.lock();
            System.out.println("获取写锁2：" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            v2.a = 1;
            v2.b = 2;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public void read(VolatileTest2 v2) {
        try {
            readLock.lock();
            System.out.println("获取读锁：" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            System.out.println(v2.b);
            System.out.println(v2.a + "===" + v2.a + "###" + v2.b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public void ReadWrite(VolatileTest2 v2) {
        increase(v2);
        read(v2);
        resume(v2);
    }

    public static void main(String[] args) {

        final VolatileTest2 v2 = new VolatileTest2();
        for (; ;) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    v2.ReadWrite(v2);
                }
            }).start();
        }
    }
}
