package com.future.disign_model.creator.singleton.hungry;

import java.io.Serializable;

/**
 * 饿汉式类加载的时候就初始化好了
 * 缺点就是如果这个单例不用，那么就浪费类内存空间
 */
public class HungrySingleton implements Serializable, Cloneable
{

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        /**
         * 单例模式如何实现Cloneable接口，那么lone方法体需要调用单例的创建方法
         */
        return getInstance();
//        return super.clone();
    }

    /**
     * 类加载到时候就初始化
     * final 表示初始化后就不可更改了；final修饰的变量必须在类加载的时候就完成初始化
     */
    private final static HungrySingleton hungrySingleton;

    /**
     * 使用静态代码块完成初始化
     */
    static
    {
        hungrySingleton = new HungrySingleton();
    }

    private HungrySingleton()
    {
        /**
         * 防止反射对攻击，增加增强型代码
         */
        if (hungrySingleton != null)
        {
            throw new RuntimeException("单例构造器禁止反射调用");
        }
    }

    public static HungrySingleton getInstance()
    {
        return hungrySingleton;
    }

    /**
     * 在序列化存储单例对象到时候，需要这个方法，返回的是序列化的对象，否则返回的是新的对象/这样就破坏了单例模式
     * 但实际上还是存在问题的，问题的存在是"虽然返回了序列化的对象，但还是创建了新的对象"
     *
     * @return
     */
    private Object readResolve()
    {
        return hungrySingleton;
    }
}
