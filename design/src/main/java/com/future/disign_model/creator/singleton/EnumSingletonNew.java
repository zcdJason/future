package com.future.disign_model.creator.singleton;

/**
 * Created by zcd on 2019-05-23
 * 单例推荐写法（枚举类单例不受反射和序列化影响）
 */
public class EnumSingletonNew
{
    /**私有构造函数*/
    private EnumSingletonNew(){};

    private String name="tiger";

    /**定义一个静态内部枚举类*/

    enum SingletonEnum{
        INSTANCE;
        private final EnumSingletonNew enumSingletonNew;

        SingletonEnum(){
            enumSingletonNew = new EnumSingletonNew();
        }

        public EnumSingletonNew getInstance(){
            return  enumSingletonNew;
        }

    }

    /**对外暴露一个获取实例的静态方法*/
    public static EnumSingletonNew getInstance(){
        return SingletonEnum.INSTANCE.enumSingletonNew;
    }

    public static EnumSingletonNew getInstance2(){
        return SingletonEnum.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        System.out.println(EnumSingletonNew.getInstance().name);
        System.out.println(EnumSingletonNew.getInstance2().name);
    }
}
