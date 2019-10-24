package com.future.disign_model.creator.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

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
         * 将单例对象序列号存储到文件，再从文件中拿出，那么还是同一个对象吗
         */
//        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
//
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton_file"));
//        oos.writeObject(hungrySingleton);
//
//        ObjectInputStream  ois = new ObjectInputStream(new FileInputStream(new File("singleton_file")));
//        HungrySingleton getIns = (HungrySingleton)ois.readObject();
//        System.out.println(hungrySingleton);
//        System.out.println(getIns);
//        System.out.println(getIns == hungrySingleton);

        /**
         * 反射对单例模式的破坏
         * 解决方法是在private的构造方法中增加判断
         */
//        HungrySingleton hungrySingleton = HungrySingleton.getInstance(); //对静态内部类创建的单例也适合
//        Class  cls = HungrySingleton.class;
//        Constructor  constructor = cls.getDeclaredConstructor();
        /**
         * 将私有构造器的权限打开
         */
//        constructor.setAccessible(true);
//
//        HungrySingleton instance = (HungrySingleton) constructor.newInstance();
//        System.out.println(hungrySingleton);
//        System.out.println(instance);
//        System.out.println(instance == hungrySingleton);

        Class  cls = LazySingleton.class;
        Constructor constructor = cls.getDeclaredConstructor();
        constructor.setAccessible(true);

        LazySingleton instance  = (LazySingleton) constructor.newInstance();

        /**
         * 虽然私有构造方法通过flag来避免反射创建，但是可以通过反射获设置flag的值来创建
         */
        Field field = instance.getClass().getDeclaredField("flag");
        field.setAccessible(true);
        field.set(instance, true);

        LazySingleton lazySingleton = LazySingleton.getLazySingleton();
        System.out.println(instance);
        System.out.println(lazySingleton);
        System.out.println(instance == lazySingleton);
    }

}
