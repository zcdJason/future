package com.future.data.structure.ThreadQuestion;

/**
 * @author: Cock a doodle doo
 */
public class VolatileTest3 {
    private static byte[] lock = new byte[0];
    private volatile int a;
    private long valTime;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public long getValTime() {
        return valTime;
    }

    public void setValTime(long valTime) {
        this.valTime = valTime;
    }

    public void print(int i) {
        synchronized (lock) {
            System.out.println("write：" + i + "  " + System.nanoTime());
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void read(int a) {
        synchronized (lock) {
            System.out.println("   read:" + a + " " + System.nanoTime());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.notify();
        }
    }

    public static void main(String[] args) {
        VolatileTest3 vt = new VolatileTest3();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 10; i++) {
                    vt.setA(i);
                    vt.print(i);
//                    Thread.yield();
                    if (i % 4 == 0)
                        i = 0;
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    vt.read(vt.getA());
//                    Thread.yield();
                }

            }
        }).start();
    }
}