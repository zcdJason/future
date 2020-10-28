package com.future.thinkInJava5.concurrent;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/ParallelPrime.java

import java.util.*;
import java.util.stream.*;

import static java.util.stream.LongStream.*;

import java.io.*;
import java.nio.file.*;
import com.future.thinkInJava5.onjava.Timer;

public class ParallelPrime {

    static final int COUNT = 100_000;

    public static boolean isPrime(long n) {
        return rangeClosed(2, (long) Math.sqrt(n)).noneMatch(i -> n % i == 0);
    }

    public static void main(String[] args)
        throws IOException {
        Timer timer = new Timer();
        List<String> primes =
            iterate(2, i -> i + 1)
                .parallel()              // [1]
                .filter(ParallelPrime::isPrime)
                .limit(COUNT)
                .mapToObj(Long::toString)
                .collect(Collectors.toList());
        System.out.println("纳秒：" + timer.duration());
        Files.write(Paths.get("primes.txt"), primes, StandardOpenOption.CREATE);
    }
}

