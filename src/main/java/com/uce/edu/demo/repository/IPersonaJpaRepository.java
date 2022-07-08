package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Persona;

public interface IPersonaJpaRepository {
	public void insertar(Persona p);
	public List<Persona> buscarPorNombre(String nombre);
	public List<Persona> buscarPorGenero(String genero);
	public List<Persona> buscarPorApellido(String apellido);
	public Persona buscarPorCedula(String cedula);
	public Persona buscarPorId(Integer id);
	public void actualizar(Persona p);
	public void eliminar(Integer id);
}
