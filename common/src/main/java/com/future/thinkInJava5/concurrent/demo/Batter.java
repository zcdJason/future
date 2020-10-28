package com.future.thinkInJava5.concurrent.demo;

import com.future.thinkInJava5.onjava.Nap;
import java.util.concurrent.CompletableFuture;

/**
 * 模拟蛋糕的制作过程
 * <p>
 * 面糊类
 *
 * @author Cock-a-doodle-doo!
 */
public class Batter {



    static class Eggs {} //鸡蛋

    static class Milk {} //牛奶

    static class Sugar {} //糖

    static class Flour {} //免费

    //模拟准备过程
    static <T> T prepare(T ingredient) {
        new Nap(0.01);
        return ingredient;
    }

    //每个准备过程都是异步的
    static <T> CompletableFuture<T> pare(T ingredient) {
        //给不同料，返回可完成的CompletableFuture
        return CompletableFuture.completedFuture(ingredient)
            .thenApplyAsync(Batter::prepare);
    }

    //将料搅拌为batter
    public static CompletableFuture<Batter> mix() {
        CompletableFuture<Eggs> eggs = pare(new Eggs());
        CompletableFuture<Milk> milk = pare(new Milk());
        CompletableFuture<Sugar> sugar = pare(new Sugar());
        CompletableFuture<Flour> flour = pare(new Flour());

        //材料都准备好了
        CompletableFuture.allOf(eggs, milk, sugar, flour)
            .join();

        new Nap(0.01);//mix time
        return CompletableFuture.completedFuture(new Batter());
    }
}
