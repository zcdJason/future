package com.future.disign_model.creator.singleton;


import org.junit.Test;

import java.io.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;


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

    @Test
    void testCutdownLatch() throws Exception{
         CountDownLatch c = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();
        System.out.println(3);
    }

}