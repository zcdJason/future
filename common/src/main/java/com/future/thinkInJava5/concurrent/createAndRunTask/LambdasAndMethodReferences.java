package com.future.thinkInJava5.concurrent.createAndRunTask;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/LambdasAndMethodReferences.java

import java.util.concurrent.*;

class NotRunnable {
    public void go() {
        System.out.println("NotRunnable");
    }
}

class NotCallable {
    public Integer get() {
        System.out.println("NotCallable");
        return 1;
    }
}

/**
 * 在 java8 有了 lambdas 和方法引用，你不需要受限于只能使用 Runnable 和 Callable 。
 * 因为 java8 的 lambdas 和方法引用可以通过匹配方法签名来使用（即，它支持结构一致性），
 * 所以我们可以将非 Runnable 或 Callable 的参数传递给 ExecutorService
 */
public class LambdasAndMethodReferences {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        exec.submit(() -> System.out.println("Lambda1"));
        exec.submit(new NotRunnable()::go); //非Runnable任务可以传入ExecutorService
        exec.submit(() -> new NotRunnable().go()); //非Runnable任务可以传入ExecutorService
        exec.submit(() -> new NotRunnable().go()); //非Runnable任务可以传入ExecutorService

        exec.submit(() -> {
            System.out.println("Lambda2");
            return 1;
        });
        exec.submit(new NotCallable()::get);//非Callable任务可以传入ExecutorService

        exec.shutdown();
    }
}

