package ar.edu.um.programacion2.temporada2018.hibernate.entidades;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "persona")

public class Persona {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    //@GeneratedValue(generator = "UUID")
    //@GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "nombre")
    protected String nombre;

    @Column(name = "apellido")
    protected String apellido;

    @OneToMany(mappedBy = "persona", fetch = FetchType.EAGER)
    protected Set<Vehiculo> vehiculos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Set<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(Set<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        StringBuilder datos = new StringBuilder();
        datos.append("Datos de la persona:\n");
        datos.append("ID: ");
        datos.append(this.id);
        datos.append("\n");
        datos.append("Nombre: ");
        datos.append(this.nombre);
        datos.append("\n");
        datos.append("Apellido: ");
        datos.append(this.apellido);
        if(this.getVehiculos() != null && this.getVehiculos().size()>0) {
            datos.append("Autos:\n");
            for (Vehiculo v: this.vehiculos) {
                datos.append(v.toString());
            }
        }
        else {
            datos.append("Sin autos");
        }
        return datos.toString();
    }
}
