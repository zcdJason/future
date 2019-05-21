package com.future.disign_model.singleton;

import com.future.disign_model.singleton.hungry.HungrySingleton;

import java.io.*;

public class TestLazySin {
    public static void main(String[] args)throws  Exception {
//        LazySingleton lazySingleton = LazySingleton.getLazySingleton();
//        System.out.println("app end");
//        Thread t1 = new Thread(new T());
//        Thread t2 = new Thread(new T());
//        t1.start();
//        t2.start();
//        System.out.println("t1 = " + t1);
//        System.out.println("t2 = " + t2);
        /**
         * 序列号和反序列化对单例对破坏
         */
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
        oos.writeObject(hungrySingleton);

        ObjectInputStream  ois = new ObjectInputStream(new FileInputStream(new File("singleton_file")));
        HungrySingleton getIns = (HungrySingleton)ois.readObject();
        System.out.println(hungrySingleton);
        System.out.println(getIns);
        System.out.println(getIns == hungrySingleton);
    }

}
