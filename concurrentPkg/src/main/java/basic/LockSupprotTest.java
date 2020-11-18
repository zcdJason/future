package basic;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Cock-a-doodle-doo!
 */
@Slf4j(topic = "test")
public class LockSupprotTest {

    private static byte[] lock = new byte[0];

    private static int count;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (lock) {
                    count++;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                count--;
                synchronized (lock) {
                    count--;
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.info("-----count:{}", count);
    }
}
