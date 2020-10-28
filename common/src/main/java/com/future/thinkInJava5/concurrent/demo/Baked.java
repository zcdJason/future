package com.future.thinkInJava5.concurrent.demo;

import com.future.thinkInJava5.onjava.Nap;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * @author Cock-a-doodle-doo!
 *
 *
 */
public class Baked {
    //将面糊放入平底锅中加热
    static class Pan{}

    //将面糊放入平底锅中
    static Pan pan(Batter b){
        new Nap(0.1);
        return new Pan();
    }
    //加热
    static Baked  hot(Pan pan){
        new Nap(0.1);
        return new Baked();
    }

    //接收面糊，返回面包
    static CompletableFuture<Baked> bake(CompletableFuture<Batter> cfb){
        return cfb.thenApplyAsync(Baked::pan).thenApplyAsync(Baked::hot);
    }

    //加工的成品作为 CompletableFutures 流返回，批量生产
    public static Stream<CompletableFuture<Baked>> batch(){
        CompletableFuture<Batter> batter = Batter.mix();
        return Stream.of(
            bake(batter),
            bake(batter),
            bake(batter),
            bake(batter)
        );
    }
}
