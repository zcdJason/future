package com.future.thinkInJava5.concurrent.exception;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/CompletableExceptions.java

import java.util.concurrent.*;

public class CompletableExceptions {

    static CompletableFuture<Breakable> test(String id, int failcount) {
        return CompletableFuture.completedFuture(
            new Breakable(id, failcount))
            .thenApply(Breakable::work)
            .thenApply(Breakable::work)
            .thenApply(Breakable::work)
            .thenApply(Breakable::work);
    }

    // 测试 A 到 E 运行到抛出异常，然后…并没有将抛出的异常暴露给调用方。只有在测试 F 中调用 get() 时，我们才会看到抛出的异常。
    // 测试 G 表明，你可以首先检查在处理期间是否抛出异常，而不抛出该异常。然而，test H 告诉我们，不管异常是否成功，它仍然被视为已“完成”。
    // 代码的最后一部分展示了如何将异常插入到 CompletableFuture 中，而不管是否存在任何失败。
    // 在连接或获取结果时，我们使用 CompletableFuture 提供的更复杂的机制来自动响应异常，而不是使用粗糙的 try-catch。
    // 你可以使用与我们看到的所有 CompletableFuture 相同的表单来完成此操作:在链中插入一个 CompletableFuture 调用。
    // 有三个选项 exceptionally()，handle()， whenComplete()
    public static void main(String[] args) {
        // Exceptions don't appear ...
        test("A", 1);
        test("B", 2);
        test("C", 3);
        test("D", 4);
        test("E", 5);
        // ... until you try to fetch the value:
        try {
            test("F", 2).get(); // or join()
        } catch (Exception e) {
            System.out.println("异常拉");
            System.out.println(e.getMessage());
        }
        // Test for exceptions:
        System.out.println(
            //测试 G 表明，你可以首先检查在处理期间是否抛出异常，而不抛出该异常
            test("G", 2).isCompletedExceptionally()
        );
        // Counts as "done":
        //然而，test H 告诉我们，不管异常是否成功，它仍然被视为已“完成”。
        System.out.println(test("H", 2).isDone());

        // Force an exception:
        CompletableFuture<Integer> cfi =
            new CompletableFuture<>();
        System.out.println("done? " + cfi.isDone());
        cfi.completeExceptionally(
            new RuntimeException("forced"));
        try {
            cfi.get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


