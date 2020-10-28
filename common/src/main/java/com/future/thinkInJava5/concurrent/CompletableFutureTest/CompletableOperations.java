package com.future.thinkInJava5.concurrent.CompletableFutureTest;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/CompletableOperations.java

import static com.future.thinkInJava5.concurrent.CompletableFutureTest.CompletableUtilities.showr;
import static com.future.thinkInJava5.concurrent.CompletableFutureTest.CompletableUtilities.voidr;

import java.util.concurrent.*;

public class CompletableOperations {

    static CompletableFuture<Integer> cfi(int i) {
        return CompletableFuture.completedFuture(i);
    }

    public static void main(String[] args) {
        showr(cfi(1)); // Basic test

        voidr(cfi(2).runAsync(() ->
            System.out.println("runAsync")));

        voidr(cfi(3).thenRunAsync(() ->
            System.out.println("thenRunAsync")));

        voidr(CompletableFuture.runAsync(() ->
            System.out.println("runAsync is static")));

        showr(CompletableFuture.supplyAsync(() -> 99));
//thenAcceptAsync()接收了一个 Consumer，因此不会产生结果
        voidr(cfi(4).thenAcceptAsync(i ->
            System.out.println("thenAcceptAsync: " + i)));
        //thenApplyAsync() 接收一个Function, 并生成一个结果（该结果的类型可以不同于其输入类型）
        showr(cfi(5).thenApplyAsync(i -> i + "42"));
        //thenComposeAsync() 与 thenApplyAsync()非常相似，唯一区别在于其 Function 必须产生已经包装在CompletableFuture中的结果
        showr(cfi(6).thenComposeAsync(i -> cfi(i + 99)));

        CompletableFuture<Integer> c = cfi(7);

        c.obtrudeValue(111); //强制，强行设置或者重制为给定值

        showr(c);

        //使用 toCompletableFuture() 从 CompletionStage 生成一个CompletableFuture。
        showr(cfi(8).toCompletableFuture());

        c = new CompletableFuture<>();
        //显示了如何通过给它一个结果来完成一个task（future）（与 obtrudeValue() 相对，后者可能会迫使其结果替换该结果
        c.complete(9);

        showr(c);

        //如果你调用 CompletableFuture中的 cancel()方法，如果已经完成此任务，则正常结束。
        // 如果尚未完成，则使用 CancellationException 完成此 CompletableFuture
        c = new CompletableFuture<>();

        //this value has no effect in this
        //implementation because interrupts are not used to control
        // processing.
        c.cancel(true);

        System.out.println("cancelled: " +
            c.isCancelled());

        System.out.println("completed exceptionally: " +
            c.isCompletedExceptionally());

        System.out.println("done: " + c.isDone());

        System.out.println(c);

        c = new CompletableFuture<>();
        System.out.println(c.getNow(777)); //返回值，如果空则返回缺省值

        c = new CompletableFuture<>();
        c.thenApplyAsync(i -> i + 42).thenApplyAsync(i -> i * 12);

        //我们看一下依赖 (dependents) 的概念。如果我们将两个thenApplyAsync()调用链路到CompletableFuture上，
        // 则依赖项的数量不会增加，保持为 1。
        // 但是，如果我们另外将另一个thenApplyAsync()直接附加到c，则现在有两个依赖项：两个一起的链路和另一个单独附加的链路。
        //这表明你可以使用一个CompletionStage，当它完成时，可以根据其结果派生多个新任务
        System.out.println("dependents: " + c.getNumberOfDependents());

        c.thenApplyAsync(i -> i / 2);
        System.out.println("dependents: " + c.getNumberOfDependents());
    }
}

