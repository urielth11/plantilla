package com.colegio.service;

import java.util.List;

public interface CrudService <T,I> {
	T obtenerXId(I id);
	List<T> listar();
	void eliminar(I id);
	void desactivar(I id);
	T grabar(T entidad);
}
