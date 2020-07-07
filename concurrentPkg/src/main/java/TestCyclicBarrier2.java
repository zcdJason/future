import java.util.concurrent.CyclicBarrier;

/**
 * 更高级的构造函数CyclicBarrier（intparties，Runnable barrier-Action），
 * 用于在线程到达屏障时，优先执行barrierAction，方便处理更复杂的业务场景
 */
public class TestCyclicBarrier2 {
    /**
     * 设置拦截线程数为2，等待2个线程（这里是第一个线程和线程A，执行的时候优先执行线程A），然后执行主线程。
     */
    static CyclicBarrier cb = new CyclicBarrier(2, new A());
    public static void main(String[] args) {
            new Thread(() -> {
                try{
                cb.await();
                }catch (Exception e){

                }
                System.out.println(1);
            }).start();

            try{
                //主线程阻塞等待
                cb.await();
            }catch (Exception e){}
        System.out.println(2);
    }

    static class A implements Runnable{
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
