package fr.cnam.pa.inf330.tp06.exemple_01.threads;

public class SimpleThread extends Thread {
    @Override
    public void run() {
        System.out.println("Je suis un SimpleThread et mon nom est '" + Thread.currentThread().getName()+"'");
    }

    public static void main(String[] args) {
        SimpleThread.callRun();
        SimpleThread.callStart();
    }

    static private void callRun(){
        System.out.println("Appelant la méthode run()");
        new SimpleThread().run();
        System.out.println("Je suis l'Application et mon thread est '" + Thread.currentThread().getName()+"'");
    }

    static private void callStart(){
        System.out.println("Appelant la méthode start()");
        new SimpleThread().start();
        System.out.println("Je suis l'Application et mon thread est '" + Thread.currentThread().getName()+"'");
    }
}
