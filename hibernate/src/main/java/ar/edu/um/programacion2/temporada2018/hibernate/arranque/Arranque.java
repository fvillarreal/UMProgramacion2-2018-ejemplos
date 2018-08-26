package ar.edu.um.programacion2.temporada2018.hibernate.arranque;

import ar.edu.um.programacion2.temporada2018.hibernate.dao.PersonaDao;
import ar.edu.um.programacion2.temporada2018.hibernate.dao.VehiculoDao;
import ar.edu.um.programacion2.temporada2018.hibernate.entidades.Persona;
import ar.edu.um.programacion2.temporada2018.hibernate.entidades.Vehiculo;
import ar.edu.um.programacion2.temporada2018.hibernate.utils.HibernateUtils;

import java.util.*;

public class Arranque {
    public static void main(String[] args) {
        Arranque a = new Arranque();
        a.arranque();
    }

    public void arranque() {
        Persona pers = new Persona("nom01","ape01");
        PersonaDao pdao = new PersonaDao();
        VehiculoDao vdao = new VehiculoDao();
        Vehiculo v1 = new Vehiculo("taunus","ford");
        Vehiculo v2 = new Vehiculo("clio","renault");
        vdao.escribir(v1);
        vdao.escribir(v2);
        Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();
        vehiculos.add(v1);
        vehiculos.add(v2);
        pers.setVehiculos(vehiculos);
        pdao.escribir(pers);
        Persona pers_2 = new Persona("nom02","ape02");
        Vehiculo v1_2 = new Vehiculo("escort","ford");
        Vehiculo v2_2 = new Vehiculo("megane","renault");
        Set<Vehiculo> vehiculos_2 = new HashSet<Vehiculo>();
        vehiculos_2.add(v1_2);
        vehiculos_2.add(v2_2);
        pers.setVehiculos(vehiculos_2);
        pdao.escribir(pers_2);

        Persona pers2 = pdao.buscarUno(3L);
        System.out.println(pers2.toString());
        System.out.println("todos:");
        List<Persona> todos = pdao.buscarTodos();
        for (Persona per : todos) {
            System.out.println(per.toString());
        }
        HibernateUtils.shutdown();
    }
}
