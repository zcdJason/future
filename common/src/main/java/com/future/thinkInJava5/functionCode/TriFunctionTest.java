package com.future.thinkInJava5.functionCode;

/**
 * @author Cock-a-doodle-doo!
 */
// functional/TriFunctionTest.java

public class TriFunctionTest {

    static int f(int i, long l, double d) {
        return 99;
    }

    static int f2(int i, long l) {
        return 99;
    }

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> tf = TriFunctionTest::f;
        TriFunction2<Integer, Long, Integer> tf2 = TriFunctionTest::f2;

        System.out.println(tf.apply(1, 2L, 3.0));
        System.out.println(tf2.apply(1, 2L));
        tf = (i, l, d) -> 12;
        tf2 = (i, t)-> 3;

    }
}

