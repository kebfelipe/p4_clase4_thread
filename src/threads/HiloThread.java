package threads;

/**
 *
 * @author KebFelipe
 */
public class HiloThread extends Thread{

    @Override
    public void run() {
        System.out.println("Executing thread: " + currentThread().getName());
    }
    
}
