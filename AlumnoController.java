package com.colegio.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.entidad.Alumno;
import com.colegio.service.AlumnoService;

@RestController
@RequestMapping(path = "/alumno")
@Validated
public class AlumnoController {
	Logger logger = LoggerFactory.getLogger(AlumnoController.class);
	
	@Autowired
	AlumnoService alumnoS;
	
	@GetMapping
	public ResponseEntity<List<Alumno>> findAll() {
		List<Alumno> alumnos = alumnoS.listar();
		return new ResponseEntity<>(alumnos, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Alumno> findById(@PathVariable long id) {
		Alumno alumno = alumnoS.obtenerXId(id);
		return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> addProyecto(@RequestBody Alumno alumno) {
		alumno.setId(0L);
		alumnoS.grabar(alumno);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Alumno alumno, @PathVariable long id) {
		alumno.setId(id);
		alumnoS.grabar(alumno);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable long id) {
		alumnoS.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
