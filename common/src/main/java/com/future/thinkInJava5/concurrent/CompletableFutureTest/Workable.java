package com.future.thinkInJava5.concurrent.CompletableFutureTest;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/Workable.java

import com.future.thinkInJava5.onjava.Nap;
import java.util.concurrent.*;

public class Workable {

    String id;
    final double duration;

    public Workable(String id, double duration) {
        this.id = id;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Workable[" + id + "]";
    }

    public static Workable work(Workable tt) {
        new Nap(tt.duration); // Seconds
        tt.id = tt.id + "W";
        System.out.println(tt);
        return tt;
    }

    //第二种类型的 CompletableFuture 方法采用两种 CompletableFuture 并以各异方式将它们组合在一起。就像两个人在比赛一样,
    // 一个CompletableFuture通常比另一个更早地到达终点。这些方法允许你以不同的方式处理结果。
    // 为了测试这一点，我们将创建一个任务，它有一个我们可以控制的定义了完成任务所需要的时间量的参数。
    // CompletableFuture 先完成


    //在 make()中，work()方法应用于CompletableFuture。
    //work()需要一定的时间才能完成，然后它将字母 W 附加到 id 上，表示工作已经完成。
    //现在我们可以创建多个竞争的 CompletableFuture，并使用 CompletableFuture 库中的各种方法来进行操作:
    public static CompletableFuture<Workable> make(String id, double duration) {
        return CompletableFuture.completedFuture(
                new Workable(id, duration)
            ).thenApplyAsync(Workable::work);
    }
}

