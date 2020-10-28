package com.future.thinkInJava5.concurrent.CompletableFutureTest;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/QuittingCompletable.java

import com.future.thinkInJava5.concurrent.stopLongTimeTask.QuittableTask;
import com.future.thinkInJava5.concurrent.stopLongTimeTask.QuittingTasks;
import com.future.thinkInJava5.onjava.Nap;
import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

/**
 * 任务是一个 List<QuittableTask>，就像在 QuittingTasks.java 中一样，但是在这个例子中，
 * 没有 peek() 将每个 QuittableTask 提交给 ExecutorService。
 * 相反，在创建 cfutures 期间，每个任务都交给 CompletableFuture::runAsync。
 * 这执行 VerifyTask.run() 并返回 CompletableFuture<Void> 。
 * 因为 run() 不返回任何内容，所以在这种情况下我只使用 CompletableFuture 调用 join() 来等待它完成。
 *
 * 在本例中需要注意的重要一点是，运行任务不需要使用 ExecutorService。
 * 而是直接交给 CompletableFuture 管理 (不过你可以向它提供自己定义的 ExectorService)。您也不需要调用 shutdown();
 * 事实上，除非你像我在这里所做的那样显式地调用 join()，否则程序将尽快退出，而不必等待任务完成。
 */
public class QuittingCompletable {

    public static void main(String[] args) {
        //创建任务列表
        List<QuittableTask> tasks = IntStream.range(1, QuittingTasks.COUNT)
                .mapToObj(QuittableTask::new)
                .collect(Collectors.toList());

        //异步执行任务，结果通过CompletableFuture 搜集
        List<CompletableFuture<Void>> cfutures =
            tasks.stream()
                .map(CompletableFuture::runAsync)
                .collect(Collectors.toList());

        new Nap(1);
        tasks.forEach(QuittableTask::quit);
        cfutures.forEach(CompletableFuture::join);
    }
}

