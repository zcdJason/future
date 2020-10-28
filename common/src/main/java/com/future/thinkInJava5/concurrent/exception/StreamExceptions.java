package com.future.thinkInJava5.concurrent.exception;

/**
 * @author Cock-a-doodle-doo!
 */
// concurrent/StreamExceptions.java

import java.util.concurrent.*;
import java.util.stream.*;

public class StreamExceptions {

    static Stream<Breakable> test(String id, int failcount) {
        return Stream.of(new Breakable(id, failcount))
            .map(Breakable::work)
            .map(Breakable::work)
            .map(Breakable::work)
            .map(Breakable::work);
    }

    public static void main(String[] args) {
        // No operations are even applied ...
        test("A", 1);
        test("B", 2);

        Stream<Breakable> c = test("C", 3);

        test("D", 4);
        test("E", 5);
        // ... until there's a terminal operation:
        System.out.println("Entering try");
        try {
            //使用流，在你应用一个终端操作之前（e.g. forEach()），什么都不会暴露给 Client
            // Stream 在没有终端操作的情况下根本不做任何事情——但是流绝对不会存储它的异常。
            c.forEach(System.out::println);   // [1]
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

