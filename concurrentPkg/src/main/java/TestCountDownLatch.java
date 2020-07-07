import java.util.concurrent.CountDownLatch;

/**
 * 调用CountDownLatch的countDown方法时，N就会减1，
 * CountDownLatch的await方法会阻塞当前线程，直到N变成零。
 * 由于countDown方法可以用在任何地方，所以这里说的N个点，可以是N个线程，
 * 也可以是1个线程里的N个执行步骤。用在多个线程时，只需要把这个CountDownLatch的引用传递到线程里即可
 */
public class TestCountDownLatch {
    static CountDownLatch c = new CountDownLatch(2);
    public static void main(String[] args) throws  Exception{
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();
        System.out.println(3);
    }
}
