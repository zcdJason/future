package com.future.disign_model.creator.singleton;

/**
 * Created by zcd on 2019-05-23
 * 单例推荐写法（枚举类单例不受反射和序列化影响）
 */
public enum EnumSingleton
{
    INSTANCE;
    private Object data;

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public static  EnumSingleton getInstance(){
        return  INSTANCE;
    }
//    INSTANCE;
//
//    public void doSomething() {
//        System.out.println("doSomething");
//    }
    //直接通过Singleton.INSTANCE.doSomething()的方式调用即可。方便、简洁又安全。
}
