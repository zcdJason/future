package com.future.disign_model.creator.singleton;

/**
 *java语言规范 首次发生到时候一个类将被立即初始化（这里到类是泛指，包括接口等）
 * 下面情况将会导致A类立即初始化
 * 1-  A类new一个实例
 * 2-  A类的静态方法被调用
 * 3-  A类的静态成员被赋值
 * 4-  A类申请的静态成员被使用，并且这个成员不是常量成员
 * 5-  A类是一个顶级类，在这个类中有嵌套到断言语句
 *
 * class 对象有个初始化的锁
 */
public class StaticInnerClassSingleton {
    /**
     * 那个线程拿到静态内部类的class的类初始化锁，谁就获取到
     */
    private   static class InnerSingleton{
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance(){
        return InnerSingleton.staticInnerClassSingleton;
    }

    /**
     * 私有构造方法是必须到，否则外部会new出来
     */
    private StaticInnerClassSingleton(){

    }
}
