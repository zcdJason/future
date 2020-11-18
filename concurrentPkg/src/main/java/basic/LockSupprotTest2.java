package basic;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Cock-a-doodle-doo!
 */
@Slf4j(topic = "test")
public class LockSupprotTest2 {
    static final  Object lock = new Object();
    static final  byte[] lock2 = new byte[0];
    static  int counter = 0;

    public static void main(String[] args) {
        synchronized (lock){
            counter++;
        }
    }

}
