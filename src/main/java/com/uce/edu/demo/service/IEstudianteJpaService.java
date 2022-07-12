package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface IEstudianteJpaService {
	public void guardar(Estudiante e);
	public Estudiante buscarPorId(Integer id);
	
	public Estudiante buscarPorCedulaTyped(String cedula);
	public Estudiante buscarPorMateriasTyped(String materias);
	public Estudiante buscarPorCedulaNamed(String cedula);
	public Estudiante buscarPorMateriasNamed(String materias);
	public Estudiante buscarPorCedulaTypedNamed(String cedula);
	public List<Estudiante> buscarPorNombreApellidoTypedNamed(String nombre, String apellido);
	
	public void actualizar(Estudiante e);
	public void eliminar(Integer id);
	
}
