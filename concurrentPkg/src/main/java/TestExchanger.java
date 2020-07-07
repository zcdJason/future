
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用于线程间协作的工具类。Exchanger用于进行线程间的数据交换。它提供一个同步点，在这个同步点，两个线程可以交换彼此的数据。
 * 这两个线程通过exchange方法交换数据，如果第一个线程先执行exchange()方法，它会一直等待第二个线程也执行exchange方法，
 * 当两个线程都到达同步点时，这两个线程就可以交换数据，将本线程生产出来的数据传递给对方
 */
public class TestExchanger {
    private static final Exchanger<String> exgr = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);
    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    String a = "flow-A";
                    String B = exgr.exchange(a);
                    System.out.println(B);
                }catch (Exception e){}
            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    String b = "flow-A";
                    String A = exgr.exchange(b);
                    System.out.println(A.equals(b));
                }catch (Exception e){}
            }
        });

        threadPool.shutdown();
    }
}
