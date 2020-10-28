package com.future.thinkInJava5.concurrent.demo;

import com.future.thinkInJava5.onjava.Nap;
import java.util.concurrent.CompletableFuture;

/**
 * @author Cock-a-doodle-doo!
 */

final class Frosting{

    static CompletableFuture<Frosting> makeFrost(){
        new Nap(0.1);
        return CompletableFuture.completedFuture(new Frosting());
    }
}

public class FrostCake {

    //make FrostCake
    public FrostCake(Frosting frosting, Baked baked){
        new Nap(0.2);
    }

    @Override
    public String toString() {
        return "FrostCake{}";
    }

    public static void main(String[] args) {
        CompletableFuture<Integer> test = new CompletableFuture<>();

    Baked.batch().forEach(
            bakedFuture -> bakedFuture.thenCombineAsync(Frosting.makeFrost(), (bake, frost)->
                new FrostCake(frost, bake))
                .thenAcceptAsync(System.out::println)
            .join()
        );
    }
}
