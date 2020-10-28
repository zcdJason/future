package com.future.thinkInJava5.concurrent.exception;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/CatchCompletableExceptions.java

import java.util.concurrent.*;

public class CatchCompletableExceptions {

    static void handleException(int failcount) {
        // Call the Function only if there's an
        // exception, must produce same type as came in:
        CompletableExceptions.test("exceptionally", failcount)
            //exceptionally() 参数仅在出现异常时才运行。exceptionally() 局限性在于，该函数只能返回输入类型相同的值
            .exceptionally((ex) -> { // Function
                if (ex == null) {
                    System.out.println("I don't get it yet");
                }
                //通过将一个好的对象插入到流中来恢复到一个可行的状态
                return new Breakable(ex.getMessage(), 0);
            }).thenAccept(str ->
                System.out.println("result: " + str));

        // Create a new result (recover):
        CompletableExceptions.test("handle", failcount)
            //一直被调用来查看是否发生异常（必须检查 fail 是否为 true）
            //但是 handle() 可以生成任何新类型，所以它允许执行处理，而不是像使用 exceptionally()那样简单地恢复
            .handle((result, fail) -> { // BiFunction
                if (fail != null) {
                    return "Failure recovery object";
                } else {
                    return result + " is good";
                }
            }).thenAccept(str -> System.out.println("result: " + str));

        // Do something but pass the same result through:
        CompletableExceptions.test("whenComplete", failcount)
            //类似于 handle()，同样必须测试它是否失败，但是参数是一个消费者，并且不修改传递给它的结果对象
            .whenComplete((result, fail) -> { // BiConsumer
                if (fail != null) {
                    System.out.println("It failed");
                } else {
                    System.out.println(result + " OK");
                }
            }).thenAccept(r ->
                System.out.println("result: " + r));
    }

    //你可以使用与我们看到的所有 CompletableFuture 相同的表单来完成此操作:
    // 在链中插入一个 CompletableFuture 调用。有三个选项 exceptionally()，handle()， whenComplete()
    public static void main(String[] args) {
        System.out.println("**** Failure Mode ****");
        handleException(2);
        System.out.println("**** Success Mode ****");
        handleException(0);
    }
}

