package com.future.effectJava;

/**
 * @author: Cock a doodle doo
 */
public final  class Complex {
    private final double a;//如果是final修饰的实例变量，系统不会自动初始化，需要在构造函数中进行初始化；一旦构造完成实例，该变量值就是不可变的
    private final double b;
    public Complex(double a, double b){
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        Complex a = new Complex(1,2);
        System.out.println(a.a);
        System.out.println(a.b);

        Complex aa = new Complex(11,22);
        System.out.println(aa.a);
        System.out.println(aa.b);


        String str = "test";
        System.out.println(str);
    }
}
