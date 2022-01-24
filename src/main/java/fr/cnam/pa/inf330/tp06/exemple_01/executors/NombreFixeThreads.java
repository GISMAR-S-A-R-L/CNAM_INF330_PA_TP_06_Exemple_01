package fr.cnam.pa.inf330.tp06.exemple_01.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class NombreFixeThreads {
    public static void main(String... args) {

        Runnable tache = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.println("Thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        // Pool avec 4 threads
        ExecutorService pool = Executors.newFixedThreadPool(4);
        // Exécuter 6 fois la même tâche
        IntStream.range(0, 6).forEach(i -> {
            pool.submit(tache);
        });
        pool.shutdown();
        System.out.println("Je suis dans le thread : " + Thread.currentThread().getName());
    }
}
