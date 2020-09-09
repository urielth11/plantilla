package com.colegio.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegio.controller.AlumnoController;
import com.colegio.entidad.Alumno;
import com.colegio.service.AlumnoService;
import com.colegio.dao.AlumnoDao;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	Logger logger = LoggerFactory.getLogger(AlumnoController.class);
	
	@Autowired
	AlumnoDao alumnoDao;

	@Override
	public Alumno obtenerXId(Long id) {
		Alumno alumno = alumnoDao.findById(id).orElse(null);
		if (alumno == null) {
			logger.warn("Alumno no encontrado");
		}
		return alumno;
	}

	@Override
	public List<Alumno> listar() {
		List<Alumno> list = alumnoDao.findAll();
		return list;
	}

	@Override
	public void eliminar(Long id) {
		alumnoDao.deleteById(id);
	}

	@Override
	public void desactivar(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Alumno grabar(Alumno entidad) {
		return alumnoDao.save(entidad);
	}


}
