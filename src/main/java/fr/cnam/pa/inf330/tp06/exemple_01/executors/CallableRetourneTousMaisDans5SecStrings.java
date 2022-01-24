package fr.cnam.pa.inf330.tp06.exemple_01.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableRetourneTousMaisDans5SecStrings {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<String> aCallableA = new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Thread aCallableA en cours!!!");
                return "Thread aCallableA: '" + Thread.currentThread().getName() + "(sleep " + 3 + ")";
            }
        };
        Callable<String> aCallableB = new Callable<String>() {
            @Override
            public String call() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    return "mmm,  thread sleep interrompu peut-être?!!!";
                }
                System.out.println("Thread aCallableB en cours!!!");
                return "Thread aCallableB: '" + Thread.currentThread().getName() + "(sleep " + 10 + ")";
            }
        };
        long start = System.currentTimeMillis();

        List<Future<String>> lesResultats = new ArrayList<>();

        try {
            lesResultats.add(executorService.submit(aCallableA));
            lesResultats.add(executorService.submit(aCallableB));
            executorService.shutdown();
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                System.out.println("Allez, on arrête!!!");
            }
            lesResultats.stream().forEach(f -> {
                try {
                    System.out.println(f.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            executorService.shutdownNow();
        }
        System.out.println("Durée : " + ((System.currentTimeMillis() - start) / 1000) + " secondes");
    }
}
