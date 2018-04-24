package ar.edu.um.programacion2_2018.prod_cons;

public class ContenedorBerreta implements Container{

    protected String elemento;

    public ContenedorBerreta() {
        this.elemento = "";
    }

    public String getElemento() {
        String retornar = this.elemento;
        this.elemento = "";
        //System.out.println("elemento obtenido");
        return retornar;
    }

    public void ponerElemento(String elemento) {

        char[] caracteres = elemento.toCharArray();
        for(int i = 0; i < caracteres.length; i++) {
            this.elemento = this.elemento + String.valueOf(caracteres[i]);
            try {
                Thread.sleep(35);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //this.elemento = elemento;
        //System.out.println("elemento puesto");
    }
}
