package fr.cnam.pa.inf330.tp06.exemple_01.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableRetourneTousStrings {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<String> aCallableA = new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                return "Thread aCallableA: '" + Thread.currentThread().getName() + "(sleep " + 3 + ")";
            }
        };
        Callable<String> aCallableB = new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(10);
                return "Thread aCallableB: '" + Thread.currentThread().getName() + "(sleep " + 10 + ")";
            }
        };
        long start = System.currentTimeMillis();
        List<Callable<String>> listOfCallables = Arrays.asList(aCallableA, aCallableB);
        try {
            List<Future<String>> allStrings = executorService.invokeAll(listOfCallables);
            for (Future<String> fString : allStrings) {
                System.out.println("Résult : " + fString.get());
            }
            System.out.println("Durée : " + ((System.currentTimeMillis()-start)/1000) + " secondes");
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
