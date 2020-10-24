package basic;

import static java.lang.Thread.sleep;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Cock-a-doodle-doo!
 */

@Slf4j(topic = "demo")
public class DaemonThread{

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(()->{
           log.debug("start demo t1");
            try {
                sleep(2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                log.debug("demo exit....");
            }

        }, "demo");
        t1.setDaemon(true);
        t1.start();
        sleep(10000);
        log.info("main end");
    }
}
