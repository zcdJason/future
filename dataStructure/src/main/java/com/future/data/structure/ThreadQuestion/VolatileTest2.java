package com.future.data.structure.ThreadQuestion;

/**
 * @author: Cock a doodle doo
 * <p>
 * 下面的这段代码有问题，为什么会出现a = 1 ,b = 100的情况？
 */
public class VolatileTest2 {
    public volatile int a = 1;
    public volatile int b = 2;

    public void increase() {
        a = 100;
        b = a;
    }

    public static void main(String[] args) {
        for (; ; ) {
            final  VolatileTest2 v2 = new VolatileTest2();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    v2.increase();
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
//                    if(v2.a == 1 && v2.b == 100)
                    System.out.println(v2.a + "-----" + v2.b);
                    System.out.println(v2.a + "-----" + v2.b);
//                        System.out.println("a=" + v2.a + " b=" + v2.b);
                }
            }).start();
        }
    }
}
