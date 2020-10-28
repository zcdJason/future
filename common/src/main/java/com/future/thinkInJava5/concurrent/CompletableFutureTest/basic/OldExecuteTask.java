package com.future.thinkInJava5.concurrent.CompletableFutureTest.basic;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Cock-a-doodle-doo!
 */
public class OldExecuteTask {

    public static CompletableFuture<Integer> compute(){
        return new CompletableFuture<>();
    }

    public static void main(String[] args) {
        CompletableFuture<Integer> future = OldExecuteTask.compute();
        future.complete(100);
        System.out.println(future.join());
    }
}
