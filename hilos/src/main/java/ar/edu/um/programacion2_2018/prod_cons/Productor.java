package ar.edu.um.programacion2_2018.prod_cons;

import java.util.concurrent.Callable;

public class Productor implements Callable<Boolean> {
    protected Container contenedor;
    protected int dormir;

    public Container getContenedor() {
        return contenedor;
    }

    public void setContenedor(Container contenedor) {
        this.contenedor = contenedor;
    }

    public int getDormir() {
        return dormir;
    }

    public void setDormir(int dormir) {
        this.dormir = dormir;
    }

    public Productor() {
    }

    public Productor(Container contenedor, int dormir) {
        this.contenedor = contenedor;
        this.dormir = dormir;
    }

    public Boolean call() throws Exception {
        for (int contador = 0; contador < 10; contador++) {
            Thread.sleep(this.dormir);
            String contenido = "producto" + String.valueOf(contador);
            this.contenedor.ponerElemento(contenido);
            System.out.println("Puesto en contenedor: "+contenido);
        }
        return true;
    }
}
