package ar.edu.um.programacion2.temporada2018.demoweb2.controladores;


import ar.edu.um.programacion2.temporada2018.demoweb2.entidades.Persona;
import ar.edu.um.programacion2.temporada2018.demoweb2.repositorios.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/personarest")
public class PersonaRestController {

    @Autowired
    PersonaRepository persRep;

    @GetMapping("/")
    public List<Persona> leerTodos() {
        List<Persona> personas = persRep.findAll();
        return personas;
    }

    @GetMapping("/{id}/{pepe}")
    public Persona leerUno(@PathVariable(name="id") Long id) {
        Persona p = persRep.findById(id).orElse(null);
        return p;
    }

    @PostMapping("/")
    public Persona grabar(@Valid @RequestBody Persona persona) {
        Persona nueva = persRep.save(persona);
        return nueva;
    }

}
