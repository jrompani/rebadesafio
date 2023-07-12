package com.reba.application.controller;

import com.reba.application.model.DatosContacto;
import com.reba.application.service.DatosContactoService;
import com.reba.application.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.reba.application.model.Persona;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	PersonaService personaService;

	@Autowired
	DatosContactoService datosContactoService;

	@PostMapping
	public ResponseEntity<?> crearPersona(@Valid @RequestBody Persona persona, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<String> errores = bindingResult.getFieldErrors().stream()
					.map(FieldError::getDefaultMessage)
					.collect(Collectors.toList());

			return ResponseEntity.badRequest().body(errores);
		}

		personaService.save(persona);

		return ResponseEntity.status(HttpStatus.CREATED).body("Persona creada exitosamente");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarPersona(@PathVariable Long id){
		personaService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Persona> response = personaService.findById(id);
		if (response.isPresent()) {
			Persona persona = response.get();
			return ResponseEntity.status(HttpStatus.FOUND).body(persona);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<List<Persona>> findAll() {
		List<Persona> personas = personaService.findAll();
		return ResponseEntity.ok(personas);
	}

	@PostMapping("/{id}/datos-contacto")
	public ResponseEntity<?> crearDatosContacto(@PathVariable Long id, @Valid @RequestBody DatosContacto datosContacto){
		Optional<Persona> persona = this.personaService.findById(id);
		if(persona!=null){
			datosContacto.setPersona(persona.get());
			datosContactoService.save(datosContacto);
			return ResponseEntity.ok().build();
		}else{
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Persona> actualizarPersona(
			@PathVariable Long id,
			@Valid @RequestBody Persona personaActualizar
	) {
		var personaExistente = personaService.findById(id);

		if (personaExistente == null) {
			return ResponseEntity.notFound().build();
		}

		Persona personaActualizada = personaService.actualizarPersona(personaExistente.get(), personaActualizar);

		return ResponseEntity.status(HttpStatus.OK).body(personaActualizada);
	}

	@GetMapping("/{id1}/padre/{id2}")
	public ResponseEntity<String> consultarPadre(@PathVariable Long id1, @PathVariable Long id2) {
		try {
			boolean esPadre = personaService.esPadre(id1, id2);
			if (esPadre) {
				return ResponseEntity.ok("La persona con ID " + id1 + " es hijo de la persona con ID " + id2);
			} else {
				return ResponseEntity.ok("La persona con ID " + id2 + " NO es hijo de la persona con ID " + id1);
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Error al consultar la relación padre-hijo: " + e.getMessage());
		}
	}
}
