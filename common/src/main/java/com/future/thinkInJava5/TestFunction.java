package com.future.thinkInJava5;

import java.util.function.Function;

/**
 * @author Cock-a-doodle-doo!
 */
public class TestFunction {

    public static long measureFuncPerform(Function<Long, Long> f, long accept) {
        long fast = Long.MAX_VALUE;
        for (int i = 0; i <= 10; i++) {
            long startTime = System.nanoTime();
            //invoke function
            long res = f.apply(accept);

            long durationTime = (System.nanoTime() - startTime) / 1_000_000;
            System.out.println("result: " + res);
            if (durationTime < fast) {
                fast = durationTime;
            }
        }
        return fast;
    }
}
