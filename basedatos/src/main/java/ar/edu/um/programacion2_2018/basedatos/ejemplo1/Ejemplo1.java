package ar.edu.um.programacion2_2018.basedatos.ejemplo1;

import java.sql.*;

public class Ejemplo1 {
    public static void main(String[] args) {
        Ejemplo1 ejemplo = new Ejemplo1();
        ejemplo.insertar();
        ejemplo.mostrar();
    }

    public void insertar() {
        // Paso 1 - conexion a la base de datos
        String usuario = "fernando";
        String password = "fernando";
        String url = "jdbc:mysql://localhost:3306/programacion2_2018?user=" + usuario
                + "&password=" + password;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = null;
        Statement stmt = null;
        PreparedStatement stmt2 = null;
        try {
            con = DriverManager.getConnection(url);
            if (con != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
            e.printStackTrace();
        }

        // Paso 2 - ejecucion de SQL
        String sqlInsertar = "insert into persona values (null,'pepe', 'hongo');";
        String sqlInsertar2 = "insert into persona values (null,?, ?);";
        try {
            stmt=con.createStatement();
            stmt.execute(sqlInsertar);

            stmt2=con.prepareStatement(sqlInsertar2);
            stmt2.setString(1,"pepe stmt");
            stmt2.setString(2,"hongo stmt");
            stmt2.execute();

            //Paso 3 - leer datos

            //Paso 4 - Cerrar conexion
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrar() {
        // Paso 1 - conexion a la base de datos
        String usuario = "fernando";
        String password = "fernando";
        // URL de conexión
        String url = "jdbc:mysql://localhost:3306/programacion2_2018?user=" + usuario
                + "&password=" + password;
        // Registro de MySQL en el driver manager
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection con = null;
        try {
            // Abrir conexión al motor de BD
            con = DriverManager.getConnection(url);
            if (con != null) {
                System.out.println("Conectado");
            }
        } catch (SQLException e) {
            System.out.println("No se pudo conectar a la base de datos");
            e.printStackTrace();
        }

        // Paso 2 - ejecucion de SQL
        Statement stmt = null;
        ResultSet rs = null;
        String sqlBuscar = "select id, nombre, apellido from persona;";
        try {
            stmt= con.createStatement();
            rs = stmt.executeQuery(sqlBuscar);
            //Paso 3 - leer datos
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                System.out.println("ID: "+String.valueOf(id)+" - Nombre: "+nombre+" - Apellido: "+apellido);
            }
            //Paso 4 - Cerrar conexion
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
