package com.future.thinkInJava5.concurrent;

import com.future.thinkInJava5.onjava.Rand;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Cock-a-doodle-doo!
 */
public class CollectionIntoStream {

    public static void main(String[] args) {
        List<String>  strings = Stream.generate(new Rand.String(5))
            .limit(5)
            .collect(Collectors.toList());
        strings.forEach(System.out::println);

        String res = strings.stream().map(String::toUpperCase)
            .map(x -> x.substring(2))
            .reduce(":", (x, y) -> x + y);
        System.out.println(res);
    }
}
