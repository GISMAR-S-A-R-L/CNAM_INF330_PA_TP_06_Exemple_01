package fr.cnam.pa.inf330.tp06.exemple_01.runnables;

public class SimpleRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000 * (int) ((Math.random() * (5 - 1)) + 1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Je suis un Runnable dont le nom de mon Thread est '" +
                Thread.currentThread().getName()+"'");
    }

    public static void main(String[] args) {
        System.out.println("Je suis l'Application et mon thread est '" + Thread.currentThread().getName()+"'");
        new Thread(new SimpleRunnable(),"ASimpleRunnable1").start();
        new Thread(new SimpleRunnable(),"ASimpleRunnable2").start();
        new Thread(new SimpleRunnable(),"ASimpleRunnable3").start();
    }
}
