package issues.starvation;

/**
 *
 * @author KebFelipe
 */
public class StarvationDemo {

    public static void main(String[] args) {
        Thread hiloAltaPrioridad = new Thread(new TareaAltaPrioridad(), "Hilo alta prioridad");
        Thread hiloBajaPrioridad = new Thread(new TareaBajaPrioridad(), "Hilo baja prioridad");

        hiloAltaPrioridad.setPriority(Thread.MAX_PRIORITY);
        hiloBajaPrioridad.setPriority(Thread.MIN_PRIORITY);

        hiloAltaPrioridad.start();
        hiloBajaPrioridad.start();
    }

    static class TareaAltaPrioridad implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println("Hilo de alta prioridad ejecutandose");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

        }
    }

    static class TareaBajaPrioridad implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println("Hilo de baja prioridad ejecutandose");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
