package fr.cnam.pa.inf330.tp06.exemple_01.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CallableRetourneAnyString {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> aCallableA = new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                return "Thread aCallableA: '" + Thread.currentThread().getName() + "(sleep " + 3 +")";
            }
        };
        Callable<String> aCallableB = new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(4);
                return "Thread aCallableB: '" + Thread.currentThread().getName() + "(sleep " + 4 +")";
            }
        };
        List<Callable<String>> listOfCallables = Arrays.asList(aCallableA,aCallableB);
        try {
            String res = executorService.invokeAny(listOfCallables);
            System.out.println("Résult : " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
