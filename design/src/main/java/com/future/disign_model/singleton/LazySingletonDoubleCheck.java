package com.future.disign_model.singleton;

public class LazySingletonDoubleCheck {
    /**
     * 双重验证，兼顾性能和多线程安全到解决方案
     */

//    private static  LazySingletonDoubleCheck lazySingletonDoubleCheck = null;
    /**
     * 第一：使用volatile关键字会强制将修改的值立即写入主存；
     *
     * 　　第二：使用volatile关键字的话，当线程2进行修改时，会导致线程1的工作内存中缓存变量stop的缓存行无效（反映到硬件层的话，就是CPU的L1或者L2缓存中对应的缓存行无效）；
     *
     * 　　第三：由于线程1的工作内存中缓存变量stop的缓存行无效，所以线程1再次读取变量stop的值时会去主存读取。
     *
     * volatile 和 synchronized 最大对区别是 (原子性，可见性，有序性）中对原子性不保证
     */
    private static volatile LazySingletonDoubleCheck lazySingletonDoubleCheck = null;

    private LazySingletonDoubleCheck(){}

    /**非线程安全
     * 静态方法上加同步锁相当于锁这个class
     * 同步锁性能损耗大，有加锁和解锁到开销，而且锁这个类，比较重
     * 双重检测是对同步锁对一种优化**/

    public synchronized static LazySingletonDoubleCheck getLazySingleton()
    {
        if(lazySingletonDoubleCheck == null){
            synchronized (LazySingletonDoubleCheck.class){
                if(lazySingletonDoubleCheck == null){
                    /**
                     * 这里存在一个问题？什么问题？
                     * 为了获得较高的执行效能，Java内存模型并没有限制执行引起使用处理器的特定寄存器或者缓存来和主内存进行交互，
                     * 也没有限制即时编译器进行调整代码执行顺序这类优化措施。
                     * JMM规定了所有的变量都存储在主内存（Main Memory）中。
                     * 每个线程还有自己的工作内存（Working Memory）,线程的工作内存中保存了该线程使用到的变量的主内存的副本拷贝，
                     * 线程对变量的所有操作（读取、赋值等）都必须在工作内存中进行，
                     * 而不能直接读写主内存中的变量（volatile变量仍然有工作内存的拷贝，但是由于它特殊的操作顺序性规定，所以看起来如同直接在主内存中读写访问一般）。
                     * 不同的线程之间也无法直接访问对方工作内存中的变量，线程之间值的传递都需要通过主内存来完成。
                     * 注意：如果实例不用volatile修饰对话，也可能获取到不同到实例，因为
                     * 类到初始化有三个步骤：
                     * 1- 分配对象到内存空间
                     * 3- 设置instance 指向内存空间
                     * 2- 初始化对象
                     * 其中到步骤2，3 编译器优化的时候可能调整执行顺序，从而导致获取到不同到实例
                     */
                    lazySingletonDoubleCheck = new LazySingletonDoubleCheck();
                }
            }
        }
        return lazySingletonDoubleCheck;
    }
}
