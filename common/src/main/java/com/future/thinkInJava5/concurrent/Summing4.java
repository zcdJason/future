package com.future.thinkInJava5.concurrent;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/Summing4.java
// {ExcludeFromTravisCI}

import java.util.*;

public class Summing4 {

    public static void main(String[] args) {
        System.out.println(Summing3.CHECK);
        Long[] aL = new Long[Summing3.SZ + 1];

        Arrays.parallelSetAll(aL, i -> (long) i);
        Summing.timeTest("Long Parallel",
            Summing3.CHECK, () ->
                Arrays.stream(aL)
                    .parallel()
                    //identity必须是accumulator函数的一个identity，也就是说必须满足：
                    // 对于所有的t,都必须满足 accumulator.apply(identity, t) == t
                    .reduce(0L, Long::sum));
    }
}
