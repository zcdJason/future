package com.future.thinkInJava5.concurrent.CompletableFutureTest;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/DualCompletableOperations.java

import static com.future.thinkInJava5.concurrent.CompletableFutureTest.CompletableUtilities.showr;
import static com.future.thinkInJava5.concurrent.CompletableFutureTest.CompletableUtilities.voidr;

import java.util.concurrent.*;


public class DualCompletableOperations {

    static CompletableFuture<Workable> cfA, cfB;

    static void init() {
        cfA = Workable.make("A", 0.15);
        cfB = Workable.make("B", 0.10); // Always wins
    }

    static void join() {
        cfA.join();
        cfB.join();
        System.out.println("*****************");
    }

    //为了方便访问， 将 cfA 和 cfB 定义为 static的。
    //init()方法用于 A, B 初始化这两个变量，因为 B 总是给出比A较短的延迟，所以总是 win 的一方。
    //join() 是在两个方法上调用 join() 并显示边框的另一个便利方法。
    //所有这些 “dual” 方法都以一个 CompletableFuture 作为调用该方法的对象，第二个 CompletableFuture 作为第一个参数，然后是要执行的操作。
    //通过使用 showr() 和 voidr() 可以看到，“run”和“accept”是终端操作，而“apply”和“combine”则生成新的 payload-bearing (承载负载) 的 CompletableFuture。
    //方法的名称不言自明，你可以通过查看输出来验证这一点。一个特别有趣的方法是 combineAsync()，
    // 它等待两个 CompletableFuture 完成，然后将它们都交给一个 BiFunction，这个 BiFunction 可以将结果加入到最终的 CompletableFuture 的有效负载中
    public static void main(String[] args) {
        init();
        voidr(cfA.runAfterEitherAsync(cfB, () ->
            System.out.println("runAfterEither")));
        join();

        init();
        voidr(cfA.runAfterBothAsync(cfB, () ->
            System.out.println("runAfterBoth")));
        join();

        init();
        showr(cfA.applyToEitherAsync(cfB, w -> {
            System.out.println("applyToEither: " + w);
            return w;
        }));
        join();

        init();
        voidr(cfA.acceptEitherAsync(cfB, w -> {
            System.out.println("acceptEither: " + w);
        }));
        join();

        init();
        voidr(cfA.thenAcceptBothAsync(cfB, (w1, w2) -> {
            System.out.println("thenAcceptBoth: "
                + w1 + ", " + w2);
        }));
        join();

        init();
        showr(cfA.thenCombineAsync(cfB, (w1, w2) -> {
            System.out.println("thenCombine: "
                + w1 + ", " + w2);
            return w1;
        }));
        join();

        init();
        CompletableFuture<Workable>
            cfC = Workable.make("C", 0.08),
            cfD = Workable.make("D", 0.09);
        CompletableFuture.anyOf(cfA, cfB, cfC, cfD)
            .thenRunAsync(() ->
                System.out.println("anyOf"));
        join();

        init();
        cfC = Workable.make("C", 0.08);
        cfD = Workable.make("D", 0.09);
        CompletableFuture.allOf(cfA, cfB, cfC, cfD)
            .thenRunAsync(() ->
                System.out.println("allOf"));
        join();
    }
}

