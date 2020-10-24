package basic;

/**
 * @author Cock-a-doodle-doo!
 */
public class CreateThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("run body");
    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new CreateThread2());
        t1.start();
    }
}
