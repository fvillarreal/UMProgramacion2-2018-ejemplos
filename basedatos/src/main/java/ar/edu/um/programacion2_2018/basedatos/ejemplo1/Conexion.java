package ar.edu.um.programacion2_2018.basedatos.ejemplo1;

import java.sql.Connection;

public class Conexion {
    private static Conexion ourInstance;
    protected Connection con;
    public static Conexion getInstance() {
        if(ourInstance == null) {
            ourInstance = new Conexion();
            ourInstance.conectar();
        }
        return ourInstance;
    }

    private void conectar() {

    }

    private Conexion() {
    }
}
