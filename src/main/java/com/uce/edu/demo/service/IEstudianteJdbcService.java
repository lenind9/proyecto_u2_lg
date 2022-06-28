package com.uce.edu.demo.service;

import com.uce.edu.demo.to.Estudiante;

public interface IEstudianteJdbcService {
	public void guardar(Estudiante e);
	public void actualizar(Estudiante e);
	public void eliminar(int id);
	public Estudiante buscar(int id);
}
