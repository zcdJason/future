package com.future.thinkInJava5.concurrent.CompletableFutureTest;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/CompletableApplyChained.javaimport java.util.concurrent.*;

import com.future.thinkInJava5.onjava.Timer;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableApplyChained {

    //消除中间变量并将操作链接在一起，就像我们使用 Streams 一样：
    public static void main(String[] args) {
        Timer timer = new Timer();
       //回调 thenApply() 一旦开始一个操作，在完成所有任务之前，不会完成 CompletableFuture 的构建。
        // 虽然这有时很有用，但是开始所有任务通常更有价值，这样就可以运行继续前进并执行其他操作。我们可通过thenApplyAsync() 来实现此目的
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0))
                .thenApply(Machina::work)
                .thenApply(Machina::work)
                .thenApply(Machina::work)
                .thenApply(Machina::work);

        try {
            cf.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(timer.duration());
    }
}

