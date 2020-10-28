package com.future.thinkInJava5.concurrent.stopLongTimeTask;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/QuittingTasks.java

import com.future.thinkInJava5.onjava.Nap;
import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

public class QuittingTasks {

    public static final int COUNT = 150;

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        List<QuittableTask> tasks =
            IntStream.range(1, COUNT)
                .mapToObj(QuittableTask::new)
//                .forEach(es::execute);
                .peek(es::execute)
                .collect(Collectors.toList());
        new Nap(1);
        System.out.println("----------------休息好了----退出任务");
        tasks.forEach(QuittableTask::quit);
        es.shutdown();
    }
}

