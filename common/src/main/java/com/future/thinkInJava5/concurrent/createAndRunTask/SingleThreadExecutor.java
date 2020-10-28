package com.future.thinkInJava5.concurrent.createAndRunTask;

/**
 * @author Cock-a-doodle-doo!
 */
//concurrent/SingleThreadExecutor.java

import com.future.thinkInJava5.onjava.Nap;
import java.util.concurrent.*;
import java.util.stream.*;

public class SingleThreadExecutor {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        IntStream.range(0, 10)
            .mapToObj(NapTask::new)
            .forEach(exec::execute);

        System.out.println("All tasks submitted");
        //它告诉 ExecutorService 完成已经提交的任务，但不接受任何新任务。此时，这些任务仍然在运行
        exec.shutdownNow();

//        try {
//            exec.execute(new NapTask(99)); //调用shutdown后，不接受任何新任务
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //Returns true if all tasks have completed following shut down.
        // Note that isTerminated is never true unless either shutdown or shutdownNow was called first
        while (!exec.isTerminated()) {
            System.out.println(Thread.currentThread().getName() + " awaiting termination");
            new Nap(0.1);
        }
    }
}


