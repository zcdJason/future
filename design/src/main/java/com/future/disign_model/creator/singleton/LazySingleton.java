package com.future.disign_model.creator.singleton;

/**
 * @author zcd
 * 懒汉式单例模式，延迟加载
 */
public class LazySingleton
{
    private static LazySingleton lazySingleton = null;

//    private static  boolean flag = true;
    private LazySingleton() {
        if(lazySingleton != null){
            throw new RuntimeException("单例模式禁止反射调用");
        }
//        if(flag){
//            flag = false;
//        }else{
//            throw new RuntimeException("单例模式禁止反射调用");
//        }
    }

    /**
     * 非线程安全
     * 静态方法上加同步锁相当于锁这个class
     * 同步锁性能损耗大，有加锁和解锁到开销，而且锁到锁这个类，比较重
     **/
    public synchronized static LazySingleton getLazySingleton()
    {
        if (lazySingleton == null)
        {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
