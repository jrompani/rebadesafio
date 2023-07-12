package com.reba.application.tools;

import com.reba.application.model.DatosContacto;
import com.reba.application.model.Nacionalidad;
import com.reba.application.model.Persona;
import com.reba.application.repository.DatosContactoRepository;
import com.reba.application.repository.NacionalidadRepository;
import com.reba.application.repository.PersonaRepository;
import com.reba.application.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PersonaService personaService;

    @Autowired
    private PersonaRepository personaRepository;


    private NacionalidadRepository nacionalidadRepository;

    @Autowired
    public DataInitializer(PersonaService personaService, NacionalidadRepository nacionalidadRepository) {
        this.personaService = personaService;
        this.nacionalidadRepository = nacionalidadRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        inicializarPersonas();
    }

    private void inicializarPersonas() {
        List<Persona> personas = new ArrayList<>();

        Persona padre = new Persona("nombreprueba", "apellido", 22, "DNI", "12312", "argentina", new ArrayList<>(), 1L, null);
        personaRepository.save(padre);


        Persona persona1 = new Persona("Fernanda", "López", 30, "DNI", "98765432", "Argentina", new ArrayList<>(), 2L, padre);
        DatosContacto datosContacto1a = new DatosContacto("Email", "juan@example.com", persona1);
        DatosContacto datosContacto1b = new DatosContacto("Teléfono", "123456789", persona1);
        persona1.setPadre(padre);
        persona1.getDatosContacto().add(datosContacto1a);
        persona1.getDatosContacto().add(datosContacto1b);
        personas.add(persona1);

        Persona persona2 = new Persona("María", "López", 30, "DNI", "98765432", "Argentina", new ArrayList<>(), 2L, padre);
        DatosContacto datosContacto2a = new DatosContacto("Email", "maria@example.com", persona2);
        DatosContacto datosContacto2b = new DatosContacto("Teléfono", "987654321", persona2);
        persona2.setPadre(padre);
        persona2.getDatosContacto().add(datosContacto2a);
        persona2.getDatosContacto().add(datosContacto2b);
        personas.add(persona2);

        Persona persona3 = new Persona("María", "Carcolo", 30, "DNI", "98765432", "Argentina", new ArrayList<>(), 2L, padre);
        DatosContacto datosContacto3a = new DatosContacto("Email", "carlos@example.com", persona3);
        DatosContacto datosContacto3b = new DatosContacto("Teléfono", "567891234", persona3);
        persona3.setPadre(padre);
        persona3.getDatosContacto().add(datosContacto3a);
        persona3.getDatosContacto().add(datosContacto3b);
        personas.add(persona3);

        for (Persona persona : personas) {
            personaRepository.save(persona);
        }
    }
}
