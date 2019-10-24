package com.future.disign_model.creator.singleton;

/**
 * Created by zcd on 2019-05-24
 * threadLocal 对每个线程都提供一个对象，同一个线程持有一个对象
 * 但是不同都线程就持有不同的对象，它保持了线程之间的对象隔离，因此多线程访问的时候不会受影响
 */
public class ThreadLocalSingleton
{
    private ThreadLocalSingleton(){};
    private static  final ThreadLocal<ThreadLocalSingleton> threadLocalInstance = new ThreadLocal<ThreadLocalSingleton>(){
        @Override
        protected ThreadLocalSingleton initialValue()
        {
            return new ThreadLocalSingleton();
        }
    };

    public ThreadLocalSingleton getInstance()
    {
        return threadLocalInstance.get();
    }
}
