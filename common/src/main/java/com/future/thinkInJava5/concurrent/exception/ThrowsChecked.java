package com.future.thinkInJava5.concurrent.exception;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/ThrowsChecked.java

import java.util.stream.*;
import java.util.concurrent.*;

public class ThrowsChecked {

    class Checked extends Exception {}

    static ThrowsChecked nochecked(ThrowsChecked tc) {
        return tc;
    }

    static ThrowsChecked withchecked(ThrowsChecked tc) throws Checked {
        return tc;
    }


    //CompletableFuture 和 parallel Stream 都不支持包含检查性异常的操作。
    // 相反，你必须在调用操作时处理检查到的异常，这会产生不太优雅的代码
    static void testStream() {
        Stream.of(new ThrowsChecked())
            .map(ThrowsChecked::nochecked)
//             .map(ThrowsChecked::withchecked) // [1]
            .map(
                tc -> {
                    try {
                        return withchecked(tc);
                    } catch (Checked e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    static void testCompletableFuture() {
        CompletableFuture.completedFuture(new ThrowsChecked())
            .thenApply(ThrowsChecked::nochecked)
//            .thenApply(ThrowsChecked::withchecked) // [2]
            .thenApply(
                tc -> {
                    try {
                        return withchecked(tc);
                    } catch (Checked e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}

