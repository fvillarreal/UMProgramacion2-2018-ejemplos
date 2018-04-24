package ar.edu.um.programacion2_2018.prod_cons;

public class ContenedorPosta implements Container{

    protected String elemento;
    protected boolean lleno;

    public ContenedorPosta() {
        this.elemento = "";
        this.lleno = false;
    }

    public synchronized String getElemento() {
        while(!this.lleno) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String retornar = this.elemento;
        this.elemento = "";
        this.lleno = false;
        notify();
        //System.out.println("elemento obtenido");
        return retornar;
    }

    public synchronized void ponerElemento(String elemento) {
        while(this.lleno) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        char[] caracteres = elemento.toCharArray();
        for(int i = 0; i < caracteres.length; i++) {
            this.elemento = this.elemento + String.valueOf(caracteres[i]);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.lleno = true;
        notify();
        //System.out.println("elemento puesto");
    }
}
