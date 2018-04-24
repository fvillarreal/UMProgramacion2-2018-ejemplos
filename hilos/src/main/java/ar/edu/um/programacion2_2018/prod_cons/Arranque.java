package ar.edu.um.programacion2_2018.prod_cons;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Arranque {

    public static void main(String[] args) {
        Arranque arr = new Arranque();
        arr.arrancar();

    }

    protected void arrancar() {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        int consumidorDormir = 100;
        int productorDormir = 300;
        //Container contenedor = new ContenedorBerreta();
        //Container contenedor = new ContenedorMaAMeno();
        Container contenedor = new ContenedorPosta();
        Productor prod = new Productor(contenedor,productorDormir);
        Consumidor cons = new Consumidor(contenedor, consumidorDormir);
        ex.submit(prod);
        ex.submit(cons);
        ex.shutdown();
    }
}
