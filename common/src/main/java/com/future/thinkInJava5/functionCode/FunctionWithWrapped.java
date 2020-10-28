package com.future.thinkInJava5.functionCode;

/**
 * @author Cock-a-doodle-doo!
 */
// functional/FunctionWithWrapped.java

import java.util.function.*;

public class FunctionWithWrapped {

    /**
     * 如果没有强制转换，则会收到错误消息：“Integer cannot be converted to Double”（Integer 无法转换为 Double），
     * 而使用 IntToDoubleFunction 就没有此类问题
     * @param args
     */
    public static void main(String[] args) {
        Function<Integer, Double> fid = i -> (double) i;
        IntToDoubleFunction fid2 = i -> i;

        System.out.println(fid2.applyAsDouble(3));
        System.out.println(fid.apply(3));
    }
}

