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
        /**
         * run 为 runnable 参数 ，接受一个runnable 参数异步执行，没有返回值 为void
         * public static CompletableFuture<Void> 	runAsync(Runnable runnable)
         * public static CompletableFuture<Void> 	runAsync(Runnable runnable, Executor executor)
         *
         * supply 为 Supplier函数接口参数，参数需要实现或者映符合映射的Supplier接口
         * public static <U> CompletableFuture<U> 	supplyAsync(Supplier<U> supplier)
         * public static <U> CompletableFuture<U> 	supplyAsync(Supplier<U> supplier, Executor executor)
         *
         * 以sync结尾（但是没有executor参数的）表示异步执行使用 ForkJoinPool.commonPool线程池
         *
         * 计算结果完成处理后的操作
         * public CompletableFuture<T> 	whenComplete(BiConsumer<? super T,? super Throwable> action)
         * public CompletableFuture<T> 	whenCompleteAsync(BiConsumer<? super T,? super Throwable> action)
         * public CompletableFuture<T> 	whenCompleteAsync(BiConsumer<? super T,? super Throwable> action, Executor executor)
         * public CompletableFuture<T>  exceptionally(Function<Throwable,? extends T> fn)
         * 以Async结尾表示异步执行，不以Async结尾表示使用相同线程执行
         *
         * 转换操作
         * 参数为函数接口，转换有返回值
         * public <U> CompletableFuture<U> 	thenApply(Function<? super T,? extends U> fn)
         * public <U> CompletableFuture<U> 	thenApplyAsync(Function<? super T,? extends U> fn)
         * public <U> CompletableFuture<U> 	thenApplyAsync(Function<? super T,? extends U> fn, Executor executor)
         *
         * 消费操作，接受的是Consumer 没有返回
         * public CompletableFuture<Void> 	thenAccept(Consumer<? super T> action)
         * public CompletableFuture<Void> 	thenAcceptAsync(Consumer<? super T> action)
         * public CompletableFuture<Void> 	thenAcceptAsync(Consumer<? super T> action, Executor executor)
         *
         * thenAcceptBoth：以及相关方法提供了类似的功能，当两个CompletionStage都正常完成计算的时候，
         * 就会执行提供的action，它用来组合另外一个异步的结果
         *
         * public <U> CompletableFuture<Void> 	thenAcceptBoth(CompletionStage<? extends U> other, BiConsumer<? super T,? super U> action)
         * public <U> CompletableFuture<Void> 	thenAcceptBothAsync(CompletionStage<? extends U> other, BiConsumer<? super T,? super U> action)
         * public <U> CompletableFuture<Void> 	thenAcceptBothAsync(CompletionStage<? extends U> other, BiConsumer<? super T,? super U> action, Executor executor)
         * public     CompletableFuture<Void> 	runAfterBoth(CompletionStage<?> other,  Runnable action)
         * runAfterBoth：当两个CompletionStage完成计算后，执行一个Runnable，它不使用计算结果，当然也不依赖计算结果，但是需要both计算之后执行
         * 下面的操作就是这样的，根本不使用之前的计算结果
         * public CompletableFuture<Void> 	thenRun(Runnable action)
         * public CompletableFuture<Void> 	thenRunAsync(Runnable action)
         * public CompletableFuture<Void> 	thenRunAsync(Runnable action, Executor executor)
         *
         * 融合计算
         * 第一个计算结果和 fn给出的计算结果进行合并（merge意思）
         * public <U> CompletableFuture<U> 	thenCompose(Function<? super T,? extends CompletionStage<U>> fn)
         * public <U> CompletableFuture<U> 	thenComposeAsync(Function<? super T,? extends CompletionStage<U>> fn)
         * public <U> CompletableFuture<U> 	thenComposeAsync(Function<? super T,? extends CompletionStage<U>> fn, Executor executor)
         *
         * 组合
         * Combine 表达的togther的意思，当前计算结果和其它的 CompletionStage计算结果进行组合；从角度来看是来自不同的CompletableFuture进行合并
         * 两个CompletionStage是并行执行的，它们之间并没有先后依赖顺序，other并不会等待先前的CompletableFuture执行完毕后再执行
         * 它和thenAcceptBoth类似，知识thenAcceptBoth是消费型的，没有返回值而已。
         * public <U,V> CompletableFuture<V> 	thenCombine(CompletionStage<? extends U> other, BiFunction<? super T,? super U,? extends V> fn)
         * public <U,V> CompletableFuture<V> 	thenCombineAsync(CompletionStage<? extends U> other, BiFunction<? super T,? super U,? extends V> fn)
         * public <U,V> CompletableFuture<V> 	thenCombineAsync(CompletionStage<? extends U> other, BiFunction<? super T,? super U,? extends V> fn, Executor executor)
         *
         * either（两者中的任何一个）
         * acceptEither表示任何一个 CompletionStage 完成 fun就执行 action消费操作
         * applyToEither表示任何一个 CompletionStage 完成 fn就会被执行，它的结果作为新的返回结果
         * public CompletableFuture<Void> 	acceptEither(CompletionStage<? extends T> other, Consumer<? super T> action)
         * public CompletableFuture<Void> 	acceptEitherAsync(CompletionStage<? extends T> other, Consumer<? super T> action)
         * public CompletableFuture<Void> 	acceptEitherAsync(CompletionStage<? extends T> other, Consumer<? super T> action, Executor executor)
         * public <U> CompletableFuture<U> 	applyToEither(CompletionStage<? extends T> other, Function<? super T,U> fn)
         * public <U> CompletableFuture<U> 	applyToEitherAsync(CompletionStage<? extends T> other, Function<? super T,U> fn)
         * public <U> CompletableFuture<U> 	applyToEitherAsync(CompletionStage<? extends T> other, Function<? super T,U> fn, Executor executor)
         *
         * guava 工具类
         * public static <T> CompletableFuture<List<T>> sequence(List<CompletableFuture<T>> futures) {
         *             CompletableFuture<Void> allDoneFuture = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
         *             return allDoneFuture.thenApply(v -> futures.stream().map(CompletableFuture::join).collect(Collectors.<T>toList()));
         *         }
         *         public static <T> CompletableFuture<Stream<T>> sequence(Stream<CompletableFuture<T>> futures) {
         *             List<CompletableFuture<T>> futureList = futures.filter(f -> f != null).collect(Collectors.toList());
         *             return sequence(futureList);
         *         }
         *
         * java Future 转 CompletableFuture
         * public static <T> CompletableFuture<T> toCompletable(Future<T> future, Executor executor) {
         *     return CompletableFuture.supplyAsync(() -> {
         *         try {
         *             return future.get();
         *         } catch (InterruptedException | ExecutionException e) {
         *             throw new RuntimeException(e);
         *         }
         *     }, executor);
         * }
         */

        showr(cfi(1)); // Basic test

        voidr(cfi(2).runAsync(() ->
            System.out.println("runAsync")));

        voidr(cfi(3).thenRunAsync(() ->
            System.out.println("thenRunAsync")));

        voidr(CompletableFuture.runAsync(() ->
            System.out.println("runAsync is static")));

        //提供一个异步接口
        showr(CompletableFuture.supplyAsync(() -> 99));

        //thenAcceptAsync()接收了一个 Consumer，因此不会产生结果
        voidr(cfi(4).thenAcceptAsync(i ->
            System.out.println("thenAcceptAsync: " + i)));
        //thenApplyAsync() 接收一个Function, 并生成一个结果（该结果的类型可以不同于其输入类型）
        showr(cfi(5).thenApplyAsync(i -> i + "42"));
        //thenComposeAsync() 与 thenApplyAsync()非常相似，唯一区别在于其 Function 必须产生已经包装在CompletableFuture中的结果
        showr(cfi(6).thenComposeAsync(i -> cfi(i + 99)));

        CompletableFuture<Integer> cb = cfi(7);
        showr(cfi(6).thenCombineAsync(cb, (a, b) -> a * b));
        CompletableFuture<Integer> c = cfi(7);

        c.obtrudeValue(111); //强制，强行设置或者重制为给定值

        showr(c);
        showr(c);

        //使用 toCompletableFuture() 从 CompletionStage 生成一个CompletableFuture。
        showr(cfi(8).toCompletableFuture());

        c = new CompletableFuture<>();
        //显示了如何通过给它一个结果来完成一个task（future）（与 obtrudeValue() 相对，后者可能会迫使其结果替换该结果
        c.complete(9);

        showr(c);

        // 如果你调用 CompletableFuture中的 cancel()方法，如果已经完成此任务，则正常结束。
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
        //如果结果已经计算完则返回结果或者抛出异常，否则返回给定的valueIfAbsent值
        System.out.println(c.getNow(777)); //返回值，如果空则返回缺省值
        //join返回计算的结果或者抛出一个unchecked异常(CompletionException)
        System.out.println(c.join());
        //如果结果已经计算完则返回结果或者抛出异常，否则返回给定的valueIfAbsent值。
        System.out.println(c.getNow(100));

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

