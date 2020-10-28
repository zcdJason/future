package com.future.thinkInJava5.concurrent;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/ParallelStreamPuzzle.java

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class ParallelStreamPuzzle {

    static class IntGenerator implements Supplier<Integer> {
        private int current = 0;
        @Override
        public Integer get() {
            return current++;
        }
    }

    public static void main(String[] args) {
        List<Integer> x = Stream.generate(new IntGenerator())
            .limit(10)
            .parallel()  // [1]
            .collect(Collectors.toList());
        System.out.println(x);
    }
}
/* Output:
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
*/

