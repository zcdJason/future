package com.future.thinkInJava5.concurrent.createAndRunTask;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/CachedThreadPool3.java

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class CachedThreadPool3 {

    public static Integer extractResult(Future<Integer> f) {
        try {
            return f.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<CountingTask> tasks = IntStream.range(0, 10)
                .mapToObj(CountingTask::new)
                .collect(Collectors.toList());

        //ExecutorService 允许你使用 invokeAll() 启动集合中的每个 Callable：
        //只有在所有任务完成后，invokeAll() 才会返回一个 Future 列表，每个任务一个 Future 。
        // Future 是 Java 5 中引入的机制，允许你提交任务而无需等待它完成
        List<Future<Integer>> futures = exec.invokeAll(tasks);

        Integer sum = futures.stream()
            .map(CachedThreadPool3::extractResult)
            .reduce(0, Integer::sum);
        System.out.println("sum = " + sum);
        exec.shutdown();
    }
}

