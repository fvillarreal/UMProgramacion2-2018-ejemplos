package ar.edu.um.programacion2.temporada2018.demoweb2.repositorios;

import ar.edu.um.programacion2.temporada2018.demoweb2.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    public List<Persona> findByNombreAndApellido(String nombre, String apellido);

}
