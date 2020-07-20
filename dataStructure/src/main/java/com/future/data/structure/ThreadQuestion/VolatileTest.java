package com.future.data.structure.ThreadQuestion;

/**
 * @author: Cock a doodle doo
 *
 * 下面的这段代码有问题，为什么synchronized没有起作用？
 */
public class VolatileTest {
    //1-此变量对所有线程可见
    //2-禁止指令重排
    public static volatile int race = 0;

    public  static void increase() {
            race++;
    }

    private static final int THREAD_NUM = 5;

    public static void main(String[] args) {

        for (int i = 1; i <= THREAD_NUM; i++) {
            System.out.println("启动线程：" + i);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++)
                        increase();
                }
            }).start();
        }

        //Thread.activeCount()取的是当前线程组的活跃线程数目，此处Thread.activeCount()=2 因为线程组里面有Monitor Ctrl-Break线程 监控用的
        //修改Thread.activeCount() -1 > 1即可 或者让线程sheep长点，因为需要等待其它线程把数据同步计算出来否则，主线程会退出，打印出来的结果也是多线程计算的中间结果。
        //注意debug模式不会有此问题
        //以run方式启动时，会在当前线程的线程组之中又开了一个Ctrl Break的Monitor的Socket线程，去做监听
        while (Thread.activeCount() > 2)
            Thread.yield();

        System.out.println(race);
    }

}
