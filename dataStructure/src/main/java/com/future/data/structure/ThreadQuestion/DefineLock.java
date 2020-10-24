package com.future.data.structure.ThreadQuestion;

/**
 * @author: Cock a doodle doo
 */
public class DefineLock implements Runnable {
    //定义一个轻量级的对象
    private byte[] lock = new byte[0]; //比 new Object 更加经济

    private int[] intArray = new int[10];

    public int[] getArray() {
        return intArray;
    }

    @Override
    public void run() {
        printM1();
    }

    private void printM1() {
        synchronized (lock) {
            for (; ; )
                System.out.println("printM1");
        }

    }

    public synchronized void printM2() {
        synchronized (lock) {
            for (; ; )
                System.out.println("printM2");
        }
    }

    public static void main(String[] args) {
        DefineLock f = new DefineLock();
//        Thread t = new Thread(f);
//        t.start();
//        f.printM2();
        System.out.println(f.intArray[1]);
        int[] c = f.getArray();
        c[1] = 100;
        System.out.println(c[1]);
        System.out.println(f.intArray[1]);

    }
}
