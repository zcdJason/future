package basic;

/**
 * @author Cock-a-doodle-doo!
 */
public class CreateThread extends Thread {

    @Override
    public void run() {
        System.out.println("run body");
    }


    public static void main(String[] args) {
        CreateThread c1 = new CreateThread();
        c1.start();
    }
}
