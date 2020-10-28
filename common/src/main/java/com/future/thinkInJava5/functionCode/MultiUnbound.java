package com.future.thinkInJava5.functionCode;

/**
 * @author Cock-a-doodle-doo!
 */
// functional/MultiUnbound.java

// 未绑定的方法与多参数的结合运用

class This {

    void two(int i, double d) {
    }

    void three(int i, double d, String s) {
    }

    void four(int i, double d, String s, char c) {
    }
}

interface TwoArgs {

    void call2(This athis, int i, double d);
}

interface ThreeArgs {

    void call3(This athis, int i, double d, String s);
}

interface FourArgs {

    void call4(
        This athis, int i, double d, String s, char c);
}

/**
 * 方法有更多个参数，就以第一个参数接受this的模式来处理
 */
public class MultiUnbound {

    public static void main(String[] args) {
        TwoArgs twoargs = This::two; //未绑定的方法
        ThreeArgs threeargs = This::three; //未绑定的方法
        FourArgs fourargs = This::four; //未绑定的方法
        This athis = new This();
        twoargs.call2(athis, 11, 3.14);
        threeargs.call3(athis, 11, 3.14, "Three");
        fourargs.call4(athis, 11, 3.14, "Four", 'Z');
    }
}

