package com.future.thinkInJava5;

import com.future.thinkInJava5.concurrent.ParallelPrime;
import java.util.stream.LongStream;

/**
 * @author Cock-a-doodle-doo!
 */
public class Accumulator {
    public long total;
    public void add(long input){
        total += input;
    }

    public static long sideEffection(long n){
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(0 , n).forEach(accumulator::add);
        return accumulator.total;
    }

}
