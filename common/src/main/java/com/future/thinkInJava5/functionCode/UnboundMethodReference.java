package com.future.thinkInJava5.functionCode;

/**
 * @author Cock-a-doodle-doo!
 */
// functional/UnboundMethodReference.java

// 没有方法引用的对象

class X {
    String f() {
        return "X::f()";
    }
}

interface MakeString {

    String make();
}

interface TransformX {

    String transform(X x);
}


/**
 * 截止目前，我们看到了与对应接口签名相同的方法引用。
 * 在 [1]**，我们尝试把 X 的 f() 方法引用赋值给 **MakeString。
 * 结果即使 make() 与 f() 具有相同的签名，编译也会报“invalid method reference”（无效方法引用）错误。
 * 这是因为实际上还有另一个隐藏的参数：我们的老朋友 this。 你不能在没有 X 对象的前提下调用 f()。
 * 因此，X :: f 表示未绑定的方法引用，因为它尚未“绑定”到对象。
 *
 * 要解决这个问题，我们需要一个 X 对象，所以我们的接口实际上需要一个额外的参数，如上例中的 TransformX。
 * 如果将 X :: f 赋值给 TransformX，在 Java 中是允许的。
 * 我们必须做第二个心理调整——使用未绑定的引用时，函数式方法的签名（接口中的单个方法）不再与方法引用的签名完全匹配。
 * 原因是：你需要一个对象来调用方法。
 *
 * [2] 的结果有点像脑筋急转弯。我拿到未绑定的方法引用，并且调用它的transform()方法，
 * 将一个X类的对象传递给它，最后使得 x.f() 以某种方式被调用。Java知道它必须拿到第一个参数，该参数实际就是this，然后调用方法作用在它之上。
 *
 * 如果你的方法有更多个参数，就以第一个参数接受this的模式来处理
 */
public class UnboundMethodReference {

    public static void main(String[] args) {
        // MakeString ms = X::f; // [1]
        TransformX sp = X::f; //未绑定的方法引用

        X x = new X();
        System.out.println(sp.transform(x)); // [2]
        System.out.println(x.f()); //同等效果
    }
}

