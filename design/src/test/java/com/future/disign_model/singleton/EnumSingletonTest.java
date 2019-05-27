package com.future.disign_model.singleton;

import org.junit.jupiter.api.Test;

import java.io.*;


/**
 * Created by zcd on 2019-05-23
 */
class EnumSingletonTest
{
    @Test
    void testGetInstance() throws Exception
    {
        EnumSingleton enumSingleton = EnumSingleton.getInstance();
        /**
         * new 一个枚举类持有的对象，然后持久化，看是否会受到序列化影响
         */
        enumSingleton.setData(new Object());
//
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
        oos.writeObject(enumSingleton);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("singleton_file")));
        EnumSingleton getIns = (EnumSingleton)ois.readObject();
        System.out.println(enumSingleton.getData());
        System.out.println(getIns.getData());
        System.out.println(getIns == enumSingleton);
    }

}