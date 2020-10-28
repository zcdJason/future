package com.future.thinkInJava5.concurrent.createAndRunTask;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/Futures.java

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class Futures {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Future<Integer> f = exec.submit(new CountingTask(99));
        // 当你调用 get() 时，Future 会阻塞，所以它只能解决等待任务完成才暴露问题。
        //这是一种无效的解决方案，现在不鼓励，我们推荐 Java 8 的 CompletableFuture
        System.out.println(f.get()); // [1]
        exec.shutdown();
    }
}

