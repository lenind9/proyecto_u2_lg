package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface IEstudianteJpaRepository {
	public void insertar(Estudiante e);
	public Estudiante buscarPorId(Integer id);
	
	public Estudiante buscarPorCedulaTyped(String cedula);
	public Estudiante buscarPorMateriasTyped(String materias);
	public Estudiante buscarPorCedulaNamed(String cedula);
	public Estudiante buscarPorMateriasNamed(String materias);
	public Estudiante buscarPorCedulaTypedNamed(String cedula);
	public List<Estudiante> buscarPorNombreApellidoTypedNamed(String nombre, String apellido);
	
	public Estudiante buscarPorCedulaNative(String cedula);
	public Estudiante buscarPorApellidoNative(String apellido);
	public Estudiante buscarPorCedulaNamedNative(String cedula);
	public Estudiante buscarPorApellidoNamedNative(String apellido);
	
	public List<Estudiante> buscarDinamicamente(String nombre, String apellido, Integer materias);
	public List<Estudiante> buscarDinamicamentePredicados(String nombre, String apellido, Integer materias);
	
	public void actualizar(Estudiante e);
	public void eliminar(Integer id);
}
