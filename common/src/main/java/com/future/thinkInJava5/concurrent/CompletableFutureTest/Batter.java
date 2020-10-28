package com.future.thinkInJava5.concurrent.CompletableFutureTest;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/Batter.java

import com.future.thinkInJava5.onjava.Nap;
import java.util.concurrent.*;

//面糊(煎料);面糊(用于做糕饼)
public class Batter {

    static class Eggs {}

    static class Milk {}

    static class Sugar {}

    static class Flour {}

    static <T> T prepare(T ingredient) {
        new Nap(0.1);
        return ingredient;
    }

    // [ɪnˈɡriːdiənt] 成分;(尤指烹饪)原料;
    static <T> CompletableFuture<T> prep(T ingredient) {
        return CompletableFuture.completedFuture(ingredient)
            .thenApplyAsync(Batter::prepare);
    }

    public static CompletableFuture<Batter> mix() {
        CompletableFuture<Eggs> eggs = prep(new Eggs());
        CompletableFuture<Milk> milk = prep(new Milk());
        CompletableFuture<Sugar> sugar = prep(new Sugar());
        CompletableFuture<Flour> flour = prep(new Flour());

        CompletableFuture.allOf(eggs, milk, sugar, flour).join();

        new Nap(0.1); // Mixing time
        return CompletableFuture.completedFuture(new Batter());
    }
}

