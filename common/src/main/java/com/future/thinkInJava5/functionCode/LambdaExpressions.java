package com.future.thinkInJava5.functionCode;

/**
 * @author Cock-a-doodle-doo!
 */
// functional/LambdaExpressions.java

interface Description {

    String brief();
}

interface Body {

    String detailed(String head);
}

interface Multi {

    String twoArg(String head, Double d);
}

interface Func{
    void ss(String s);
}


public class LambdaExpressions {

    static Func s = System.out::println;
    //将处理逻辑生成一个static方法
    //生成一个final类，实现lambda表达式所绑定的接口，并通过调用已生成的私有静态方法，来实现抽象方法。
    static Body bod = h -> h + " No Parens!"; // [1] Lambda 表达式方法体都是单行。 该表达式的结果自动成为 Lambda 表达式的返回值

//    static Body bod2 = (h) -> h + " More details"; // [2] Lambda 表达式方法体都是单行。 该表达式的结果自动成为 Lambda 表达式的返回值
//
//    static Description desc = () -> "Short info"; // [3] Lambda 表达式方法体都是单行。 该表达式的结果自动成为 Lambda 表达式的返回值
//
//    static Multi mult = (h, n) -> h + n; // [4]
//
//    static Description moreLines = () -> { // [5]
//        System.out.println("moreLines()");
//        return "from moreLines()";//Lambda 表达式中确实需要多行，则必须将这些行放在花括号中。 在这种情况下，就需要使用 return。
//    };

    public static void main(String[] args) {
        System.out.println(bod.detailed("Oh!"));
//        System.out.println(bod2.detailed("Hi!"));
//        System.out.println(desc.brief());
//        System.out.println(mult.twoArg("Pi! ", 3.14159));
//        System.out.println(moreLines.brief());
    }
}

