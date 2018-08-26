package ar.edu.um.programacion2.temporada2018.hibernate.entidades;

import javax.persistence.*;

@Entity
@Table(name="vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    protected Long id;

    @Column(name = "modelo")
    protected String modelo;

    @Column(name = "marca", length = 100)
    protected String marca;

    @ManyToOne
    //@JoinColumn(name="persona_id")
    protected Persona persona;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Vehiculo() {
    }

    public Vehiculo(String modelo, String marca) {
        this.modelo = modelo;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Marca: "+this.marca+" - Modelo: "+this.modelo;
    }
}
