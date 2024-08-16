package threads;

import static java.lang.Thread.currentThread;

/**
 *
 * @author KebFelipe
 */
public class HiloRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Executing thread: " + currentThread().getName());
    }
    
}
