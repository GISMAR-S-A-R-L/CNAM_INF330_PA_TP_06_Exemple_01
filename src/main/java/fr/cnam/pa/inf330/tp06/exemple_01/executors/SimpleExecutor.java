package fr.cnam.pa.inf330.tp06.exemple_01.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleExecutor {
    public static void main(String[] args) {
        Runnable tache = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.println("Thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(tache);
    }
}
