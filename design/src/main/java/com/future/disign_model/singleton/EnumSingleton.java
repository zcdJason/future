package com.future.disign_model.singleton;

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
}
