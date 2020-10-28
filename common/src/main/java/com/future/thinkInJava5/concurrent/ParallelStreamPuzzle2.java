package com.future.thinkInJava5.concurrent;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/ParallelStreamPuzzle2.java

import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.nio.file.*;

public class ParallelStreamPuzzle2 {

    public static final Deque<String> TRACE =
        new ConcurrentLinkedDeque<>();

    static class
    IntGenerator implements Supplier<Integer> {

        private AtomicInteger current = new AtomicInteger();

        @Override
        public Integer get() {
            TRACE.add(current.get() + ": " + Thread.currentThread().getName());
            return current.getAndIncrement();
        }
    }

    public static void main(String[] args) throws Exception {
        List<Integer> x = Stream.generate(new IntGenerator())
            .limit(10)
            .parallel()
            .collect(Collectors.toList());
        System.out.println(x);
        Files.write(Paths.get("PSP2.txt"), TRACE);
    }
}

