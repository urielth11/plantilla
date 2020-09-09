package com.colegio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colegio.entidad.Alumno;

@Repository
public interface AlumnoDao extends JpaRepository<Alumno, Long> {

}
