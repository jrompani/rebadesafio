package com.reba.application.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reba.application.model.Persona;
import com.reba.application.repository.PersonaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	PersonaRepository repository;

	@Override
	public Persona save(Persona persona) {
		return this.repository.save(persona);
	}

	@Override
	public void deleteById(Long id) {
		try{
			this.repository.deleteById(id);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Optional<Persona> findById(Long id) {
		return this.repository.findById(id);
	}

	public boolean esPadre(Long id1, Long id2) {
		Persona padre = repository.findById(id2).orElseThrow(() -> new NoSuchElementException("No se encontró la persona con ID " + id2));
		Persona hijo = repository.findById(id1).orElseThrow(() -> new NoSuchElementException("No se encontró la persona con ID " + id1));

		return hijo.getPadre() != null && hijo.getPadre().equals(padre);
	}

	@Override
	public List<Persona> findAll() {
		var response = repository.findAll();
		var personas = new ArrayList<Persona>();
		response.forEach(personas::add);
		return personas;
	}

	@Override
	public Persona actualizarPersona(Persona personaExistente, Persona personaActualizar) {
		BeanUtils.copyProperties(personaActualizar, personaExistente, "id");
		return repository.save(personaExistente);
	}


}
