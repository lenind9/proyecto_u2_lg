package com.uce.edu.demo.repository;

import com.uce.edu.demo.to.Persona;

public interface IPersonaJdbcRepository {
	public void insertar(Persona p);
	public Persona buscarPorId(int id);
	public void actualizar(Persona p);
	public void eliminar(int id);
}
