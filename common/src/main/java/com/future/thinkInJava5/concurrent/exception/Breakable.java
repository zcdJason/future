package com.future.thinkInJava5.concurrent.exception;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/Breakable.java

import java.util.concurrent.*;
//与 CompletableFuture 在处理链中包装对象的方式相同，它也会缓冲异常。
// 这些在处理时调用者是无感的，但仅当你尝试提取结果时才会被告知。为了说明它们是如何工作的，我们首先创建一个类，它在特定的条件下抛出一个异常
public class Breakable {

    String id;
    private int failcount;

    public Breakable(String id, int failcount) {
        this.id = id;
        this.failcount = failcount;
    }

    @Override
    public String toString() {
        return "Breakable_" + id + " [" + failcount + "]";
    }

    public static Breakable work(Breakable b) {
        if (--b.failcount == 0) {
            System.out.println(
                "Throwing Exception for " + b.id + ""
            );
            throw new RuntimeException(
                "Breakable_" + b.id + " failed"
            );
        }
        System.out.println(b);
        return b;
    }
}

