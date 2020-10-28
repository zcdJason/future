package com.future.thinkInJava5.concurrent;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/ParallelStreamPuzzle3.java
// {VisuallyInspectOutput}
import java.util.*;
import java.util.stream.*;
import com.future.thinkInJava5.onjava.Timer;
public class ParallelStreamPuzzle3 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        List<Integer> x = IntStream.range(0, 30)
            .peek(e -> System.out.println(e + ": " +Thread.currentThread()
                .getName()))
            .limit(10)
            .parallel()
            .boxed()
            .collect(Collectors.toList());
        System.out.println(x);
        System.out.println(timer.duration());
    }
}

