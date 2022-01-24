package fr.cnam.pa.inf330.tp06.exemple_01.runnables;

public class RunnableAsFunctionalInterface {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                Thread.sleep(1000 * (int) ((Math.random() * (5 - 1)) + 1));
                System.out.println("Je suis un Runnable dont le nom de mon Thread est '" +
                        Thread.currentThread().getName() + "'");
            } catch (InterruptedException e) {
                System.out.println("moi, le thread '" + Thread.currentThread().getName() +
                        "', je suis interrompu ? mais wtf!!!");
            }
        };
        new Thread(runnable, "Processus-léger").start();
    }
}
