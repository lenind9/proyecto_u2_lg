package com.uce.edu.demo.service;

import com.uce.edu.demo.to.EstudianteTo;

public interface IEstudianteJdbcService {
	public void guardar(EstudianteTo e);
	public void actualizar(EstudianteTo e);
	public void eliminar(int id);
	public EstudianteTo buscar(int id);
}
