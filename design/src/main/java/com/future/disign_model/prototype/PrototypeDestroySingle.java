package com.future.disign_model.prototype;

/**
 * @author zcd
 * @date 2019-06-03 22:46
 */

import com.future.disign_model.singleton.hungry.HungrySingleton;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 原型模式的克隆破坏单例模式
 */
public class PrototypeDestroySingle
{


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
    {
        HungrySingleton hungrySingleton =  HungrySingleton.getInstance();
        /**
         * 利用反射修改权限和调用方法
         */
        Method method = hungrySingleton.getClass().getDeclaredMethod("clone");
        method.setAccessible(true);
        HungrySingleton  copySingle = (HungrySingleton) method.invoke(hungrySingleton);
        System.out.println(copySingle);
        System.out.println(hungrySingleton);
        /**
         * 如何防止clone破坏单例呢
         * 1。不实现cloneable 接口
         * 2。如何实现类coloneable接口，那么内部调用getInstance()方法
         */
    }
}
