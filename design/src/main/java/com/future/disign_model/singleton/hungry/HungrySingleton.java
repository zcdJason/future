package com.future.disign_model.singleton.hungry;

import java.io.Serializable;

/**
 * 饿汉式类加载的时候就初始化好了
 * 缺点就是如果这个单例不用，那么就浪费类内存空间
 */
public class HungrySingleton implements  Serializable {
    /**
     * 类加载到时候就初始化
     * final 表示初始化后就不可更改了；final修饰的变量必须在类加载的时候就完成初始化
     */
    private final  static  HungrySingleton hungrySingleton;

    /**
     * 使用静态代码块完成初始化
     */
    static{
        hungrySingleton = new HungrySingleton();
    }
    private HungrySingleton(){
    }

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }

    private Object readResolve(){
        return  hungrySingleton;
    }
}
