package basic;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Cock-a-doodle-doo!
 */
@Slf4j(topic = "interrupt")
public class TPTInterrupt {

    private Thread thread;

    public void start() {
        thread = new Thread(() -> {
            for (; ; ) {
                Thread current = Thread.currentThread();
                if (current.isInterrupted()) {
                    log.debug("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    log.debug("将结果保存");
                } catch (InterruptedException e) {
                    current.interrupt();
                }
            }
        }, "监控线程");

        thread.start();
    }

    public void stop() {
        thread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        TPTInterrupt t = new TPTInterrupt();
        t.start();
        Thread.sleep(3500);
        log.debug("stop");
        t.stop();
    }

}
