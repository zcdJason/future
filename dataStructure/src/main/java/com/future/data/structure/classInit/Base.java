package com.future.data.structure.classInit;

/**
 * @author: Cock a doodle doo
 *
 */
public class Base {
    private int val;
    public Base(){
        //构造函数中调研no-final，需要注意，如果该方法被子类重写，将会发生意想不到的结果。
        val = lookup();
    }

    public  int lookup() {
        return 5;
    }

    public int value(){
        return val;
    }

    public static void main(String[] args) {
        Derved d = new Derved();
        /**
         * 正常顺序
         *  1-从heap分配内存，用来存放Derved实例的变量num，存放Base实例的变量 val， 和一份专属数据
         *  2-实例变量被初始化为 "缺省值" num= 0， val = 0
         *  3-调用Derved的构造函数-》调用Base的构造函数-》调用Object的构造函数
         *  4-object构造函数返回后，Base构造函数，给变量val赋值，然后Derved构造函数
         *
         *  如果子类重写
         *  在第四步，由于被重写，调用重写的函数lookup返回num，而此时Derved还没有构造，num是初始值0；
         *  Base构造后接着构造Derved,此时num才初始化为10。
         */
        System.out.println(d.value());//0 为什么？
        System.out.println(d.num);
    }
}
