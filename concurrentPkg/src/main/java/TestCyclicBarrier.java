import java.util.concurrent.CyclicBarrier;

/**
 * 设置同步点
 * 让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续运行。
 */
public class TestCyclicBarrier {
    static CyclicBarrier cb = new CyclicBarrier(3);
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                cb.await();
            } catch (Exception e) {

            }
            System.out.println(1);
        }).start();

        try {
            cb.await();
        } catch (Exception e) {
        }
        System.out.println(2);
    }
}
