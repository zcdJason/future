package com.future.disign_model.creator.singleton;

public class T implements Runnable {
    @Override
    public void run() {
        StaticInnerClassSingleton staticInnerClassSingleton = StaticInnerClassSingleton.getInstance();
//      LazySingleton lazySingleton = LazySingleton.getLazySingleton();
        System.out.println(Thread.currentThread().getName() + " " + staticInnerClassSingleton);
    }
}
