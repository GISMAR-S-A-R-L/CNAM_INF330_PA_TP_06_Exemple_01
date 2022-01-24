package fr.cnam.pa.inf330.tp06.exemple_01;

public class NombreThreadsDisponibles {
    public static void main(String[] args) {
        System.out.println("Nombre de threads disponibles : " + Runtime.getRuntime().availableProcessors());
    }
}