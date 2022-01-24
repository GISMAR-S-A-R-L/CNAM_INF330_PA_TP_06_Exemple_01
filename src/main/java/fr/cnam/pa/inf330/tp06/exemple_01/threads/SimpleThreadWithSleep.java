package fr.cnam.pa.inf330.tp06.exemple_01.threads;

public class SimpleThreadWithSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread unThreadAvecSommeil = new Thread("Processus-léger-marmotte") {
            @Override
            public void run() {
                try {
                    System.out.println("moi, le thread '" + Thread.currentThread().getName()+"', je suis fatigué.");
                    Thread.sleep(1000 * 5);
                    System.out.println("moi, le thread '" + Thread.currentThread().getName()+"', j'ai fini mon travail après une petite sieste'.");
                } catch (InterruptedException e) {
                    System.out.println("moi, le thread '" + Thread.currentThread().getName()+"', je suis interrompu ? mais wtf!!!" );
                }
            }
        };

        System.out.println("Lancement de l'application");
        unThreadAvecSommeil.start();
        Thread.sleep(1000 * 2);
        unThreadAvecSommeil.interrupt();
        System.out.println("Je suis l'Application et mon thread est '" + Thread.currentThread().getName()+"'");
    }
}
