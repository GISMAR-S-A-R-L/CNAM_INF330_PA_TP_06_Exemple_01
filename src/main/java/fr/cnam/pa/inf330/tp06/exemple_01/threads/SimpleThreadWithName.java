package fr.cnam.pa.inf330.tp06.exemple_01.threads;

public class SimpleThreadWithName {

    public static void main(String[] args) {
        Thread unThreadAvecNom = new Thread("Processus-léger") {
            @Override
            public void run() {
                System.out.println("Je suis un SimpleThread et mon nom est '" + Thread.currentThread().getName()+"'");
            }
        };
        unThreadAvecNom.start();
        System.out.println("Je suis l'Application et mon thread est '" + Thread.currentThread().getName()+"'");
    }

}
