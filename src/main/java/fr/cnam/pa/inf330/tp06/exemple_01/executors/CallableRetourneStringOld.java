package fr.cnam.pa.inf330.tp06.exemple_01.executors;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableRetourneStringOld {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Arrays.stream("Trouver le hashcode des mots de cette phrase".split(" ")).forEach(
                s -> {
                    executorService.submit(new StringConverter(s));
                }
        );
    }
    
    
    static class StringConverter implements Callable<Integer> {

        private final String aString;

        public StringConverter(String aString) {
            this.aString = aString;
        }

        @Override
        public Integer call() throws Exception {
            return aString.hashCode();
        }
    }
}
