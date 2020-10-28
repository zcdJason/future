package com.future.thinkInJava5.functionCode;

import java.util.function.*;

/**
 * @author Cock-a-doodle-doo!
 */
// functional/FunctionalAnnotation.java

@FunctionalInterface
interface Functional {

    String goodbye(String arg);
}

interface FunctionalNoAnn {

    String goodbye(String arg);
}


/*
@FunctionalInterface
interface NotFunctional {
  String goodbye(String arg);
  String hello(String arg);
}
产生错误信息:
NotFunctional is not a functional interface
multiple non-overriding abstract methods
found in interface NotFunctional
*/

/**
 * 问题的引入：
 * （x,y)  ->  x+ y   x是什么类型， y是什么类型，返回是什么类型，编译器必须知道它们的类型以生成正确的代码，
 * 类型推导是根据什么来推导的？
 * Java 8 引入了 java.util.function 包。它包含一组接口，这些接口是 Lambda 表达式和方法引用的目标类型。 每个接口只包含一个抽象方法，称为函数式方法
 * 它的引入就是解决上面的问题
 *
 * @FunctionalInterface 注解是可选的; Java 在 main() 中把 Functional 和 FunctionalNoAnn 都当作函数式接口。
 * 在 NotFunctional 的定义中可看到@FunctionalInterface 的作用：接口中如果有多个抽象方法则会产生编译期错误。
 *
 * 仔细观察在定义 f 和 fna 时发生了什么。
 * Functional 和 FunctionalNoAnn 定义接口，然而被赋值的只是方法 goodbye()。
 * 首先，这只是一个方法而不是类；其次，它甚至都不是实现了该接口的类中的方法。
 * 这是添加到Java 8中的一点小魔法：如果将方法引用或 Lambda 表达式赋值给函数式接口（类型需要匹配），
 * Java会适配你的赋值到目标接口。 编译器会在后台把方法引用或 Lambda 表达式包装进实现目标接口的类的实例中。
 *
 * 尽管 FunctionalAnnotation 确实适合 Functional 模型，
 * 但 Java不允许我们像fac定义中的那样，将 FunctionalAnnotation 直接赋值给 Functional，
 * 因为 FunctionalAnnotation 并没有显式地去实现 Functional 接口。唯一的惊喜是，Java 8 允许我们将函数赋值给接口，这样的语法更加简单漂亮。
 *
 * java.util.function 包旨在创建一组完整的目标接口，
 * 使得我们一般情况下不需再定义自己的接口。主要因为基本类型的存在，导致预定义的接口数量有少许增加。 如果你了解命名模式，顾名思义就能知道特定接口的作用。
 *
 * 以下是基本命名准则：
 *
 * 如果只处理对象而非基本类型，名称则为 Function，Consumer，Predicate 等。参数类型通过泛型添加。
 *
 * 如果接收的参数是基本类型，则由名称的第一部分表示，如 LongConsumer，DoubleFunction，IntPredicate 等，但返回基本类型的 Supplier 接口例外。
 *
 * 如果返回值为基本类型，则用 To 表示，如 ToLongFunction <T> 和 IntToLongFunction。
 *
 * 如果返回值类型与参数类型一致，则是一个运算符：单个参数使用 UnaryOperator，两个参数使用 BinaryOperator。
 *
 * 如果接收两个参数且返回值为布尔值，则是一个谓词（Predicate）。
 *
 * 如果接收的两个参数类型不同，则名称中有一个 Bi。
 */
public class FunctionalAnnotation {

    public String goodbye(String arg) {
        return "Goodbye, " + arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional f = fa::goodbye;
        FunctionalNoAnn fna = fa::goodbye;
        // Functional fac = fa; // Incompatible
        Functional fl = a -> "Goodbye, " + a;
        FunctionalNoAnn fnal = a -> "Goodbye, " + a;
    }
}

