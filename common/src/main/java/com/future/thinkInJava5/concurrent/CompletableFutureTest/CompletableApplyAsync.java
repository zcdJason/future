package com.future.thinkInJava5.concurrent.CompletableFutureTest;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/CompletableApplyAsync.java

import com.future.thinkInJava5.onjava.Timer;
import java.util.concurrent.*;

public class CompletableApplyAsync {

    //同步调用 (我们通常使用的那种) 意味着：“当你完成工作时，才返回”，而异步调用以意味着： “立刻返回并继续后续工作”。
    // 正如你所看到的，cf 的创建现在发生的更快。每次调用 thenApplyAsync() 都会立刻返回，
    // 因此可以进行下一次调用，整个调用链路完成速度比以前快得多。
    //
    //事实上，如果没有回调 cf.join() 方法，程序会在完成其工作之前退出。
    // 而 cf.join() 直到 cf 操作完成之前，阻止 main() 进程结束。我们还可以看出本示例大部分时间消耗在 cf.join() 这。
    //
    //这种“立即返回”的异步能力需要 CompletableFuture 库进行一些秘密（client 无感）工作。
    // 特别是，它将你需要的操作链存储为一组回调。当操作的第一个链路（后台操作）完成并返回时，
    // 第二个链路（后台操作）必须获取生成的 Machina 并开始工作，以此类推！
    // 但这种异步机制没有我们可以通过程序调用栈控制的普通函数调用序列，它的调用链路顺序会丢失，因此它使用一个函数地址来存储的回调来解决这个问题。
    //
    //幸运的是，这就是你需要了解的有关回调的全部信息。程序员将这种人为制造的混乱称为 callback hell（回调地狱）。
    // 通过异步调用，CompletableFuture 帮你管理所有回调。 除非你知道你系统中的一些特定逻辑会导致某些改变，或许你更想使用异步调用来实现程序
    public static void main(String[] args) {
        Timer timer = new Timer();
        CompletableFuture<Machina> cf = CompletableFuture.completedFuture(new Machina(0))
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work)
                .thenApplyAsync(Machina::work);

        System.out.println("main exe  other:"  + timer.duration());
        System.out.println("wait all task finish....");
        System.out.println(cf.join());
        System.out.println(timer.duration());
    }
}

