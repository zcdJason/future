package com.future.singleton;

/**
 * @author zcd
 */
public class LazySingleton {
    private static  LazySingleton lazySingleton = null;
    private LazySingleton(){}

    /**非线程安全**/
    public static LazySingleton getLazySingleton()
    {
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
            return lazySingleton;
    }
}
