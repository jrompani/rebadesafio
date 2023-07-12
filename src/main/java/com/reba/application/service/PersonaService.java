package com.reba.application.service;

import com.reba.application.model.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    Persona save(Persona persona);

    void deleteById(Long id);

    Optional<Persona> findById(Long id);

    boolean esPadre(Long id1, Long id2);

    List<Persona> findAll();

    Persona actualizarPersona(Persona personaExistente, Persona personaActualizar);
}
