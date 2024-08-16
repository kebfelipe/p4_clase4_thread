package issues.deadlock;

import static java.lang.Thread.currentThread;

public class DeadlockDemo {

    public static void main(String[] args) throws InterruptedException {
        Object ob1 = new Object();
        Object ob2 = new Object();
        Object ob3 = new Object();

        Thread t1 = new Thread(new SyncThread(ob2, ob3), "hilo1");
        Thread t2 = new Thread(new SyncThread(ob2, ob3), "hilo1");
        Thread t3 = new Thread(new SyncThread(ob2, ob3), "hilo1");

        t1.start();
        Thread.sleep(5000);
        t2.start();
        Thread.sleep(5000);
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Finalizado");
    }
}

class SyncThread implements Runnable {

    public Object ob1;

    public Object ob2;

    public SyncThread(Object ob1, Object ob2) {
        this.ob1 = ob1;
        this.ob2 = ob2;
    }

    @Override
    public void run() {
        System.out.println(currentThread().getName() + " generando lock en " + ob1);
        synchronized (ob1) {
            System.out.println(currentThread().getName() + " lock generado en " + ob1);
            work();
            System.out.println(currentThread().getName() + " generando lock en " + ob2);
            synchronized (ob2) {
                System.out.println(currentThread().getName() + " lock generado en " + ob2);
                work();
            }
            System.out.println(currentThread().getName() + " lock liberado en " + ob2);
        }
        System.out.println(currentThread().getName() + " lock liberado en " + ob1);
        System.out.println("Finalizó ejecución");
    }

    private void work() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
