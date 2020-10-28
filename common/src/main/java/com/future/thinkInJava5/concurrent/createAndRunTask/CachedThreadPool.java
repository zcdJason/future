package com.future.thinkInJava5.concurrent.createAndRunTask;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/CachedThreadPool.java

import java.util.concurrent.*;
import java.util.stream.*;

public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        IntStream.range(0, 10)
            .mapToObj(NapTask::new)
            .forEach(exec::execute);
        exec.shutdown();
    }
}

