package com.future.thinkInJava5.concurrent.CompletableFutureTest.basic;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Cock-a-doodle-doo!
 */
public class CompareRunAsyncAndThenAsync {

    //    public static void main(String[] args) {
//        ExecutorService e = Executors.newSingleThreadExecutor(r -> new Thread(r, "sole thread"));
//        CompletableFuture<?> f = CompletableFuture.runAsync(() -> {
//        }, e);
//        f.join();
//        f.thenRun(() -> System.out.println("thenRun:\t" + Thread.currentThread()));
//        f.thenRunAsync(() -> System.out.println("thenRunAsync:\t" + Thread.currentThread()));
//        f.thenRunAsync(() -> System.out.println("thenRunAsync+e:\t" + Thread.currentThread()), e);
//        e.shutdown();
//    }
    public static void main(String[] args) {
        ExecutorService e = Executors.newSingleThreadExecutor(r -> new Thread(r, "sole thread"));
        CompletableFuture<?> f = CompletableFuture
            .runAsync(() -> LockSupport.parkNanos((int) 1e9), e);
        f.thenRun(() -> System.out.println("thenRun:\t" + Thread.currentThread()));
        f.thenRunAsync(() -> System.out.println("thenRunAsync:\t" + Thread.currentThread()));
        f.thenRunAsync(() -> System.out.println("thenRunAsync+e:\t" + Thread.currentThread()), e);
        LockSupport.parkNanos((int) 2e9);
        e.shutdown();
    }
}
