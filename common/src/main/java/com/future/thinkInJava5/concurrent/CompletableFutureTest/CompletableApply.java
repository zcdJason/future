package com.future.thinkInJava5.concurrent.CompletableFutureTest;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/CompletableApply.java

import java.util.concurrent.*;

public class CompletableApply {

    /**
     * thenApply() 应用一个接收输入并产生输出的函数。
     * 在本例中，work() 函数产生的类型与它所接收的类型相同 （Machina），
     * 因此每个 CompletableFuture添加的操作的返回类型都为 Machina，
     * 但是 (类似于流中的 map() ) 函数也可以返回不同的类型，这将体现在返回类型上。
     *
     * 你可以在此处看到有关 CompletableFutures 的重要信息：它们会在你执行操作时自动解包并重新包装它们所携带的对象。
     * 这使得编写和理解代码变得更加简单， 而不会在陷入在麻烦的细节中
     * @param args
     */
    public static void main(String[] args) {
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0));/**/

        CompletableFuture<Machina> cf2 = cf.thenApply(Machina::work);
        CompletableFuture<Machina> cf3 = cf2.thenApply(Machina::work);

        CompletableFuture<Machina> cf4 = cf3.thenApply(Machina::work);
        CompletableFuture<Machina> cf5 = cf4.thenApply(Machina::work);
    }
}

