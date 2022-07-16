package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IPersonaJpaRepository;
import com.uce.edu.demo.repository.modelo.Persona;

@Service
public class PersonaJpaServiceImpl implements IPersonaJpaService {
	
	@Autowired
	private IPersonaJpaRepository personaJpaRepository;
	
	@Override
	public void guardar(Persona p) {
		// TODO Auto-generated method stub
		this.personaJpaRepository.insertar(p);
	}
	
	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.personaJpaRepository.buscarPorNombre(nombre);
	}
	
	@Override
	public List<Persona> buscarPorGenero(String genero) {
		// TODO Auto-generated method stub
		return this.personaJpaRepository.buscarPorGenero(genero);
	}
	
	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.personaJpaRepository.buscarPorApellido(apellido);
	}
	
	@Override
	public Persona buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.personaJpaRepository.buscarPorCedula(cedula);
	}
	
	@Override
	public Persona buscarPorCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		return this.personaJpaRepository.buscarPorCedulaTyped(cedula);
	}

	@Override
	public Persona buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.personaJpaRepository.buscarPorCedulaNamed(cedula);
	}

	@Override
	public Persona buscarPorCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.personaJpaRepository.buscarPorCedulaTypedNamed(cedula);
	}
	
	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		return this.personaJpaRepository.buscarPorCedulaNative(cedula);
	}
	
	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		// TODO Auto-generated method stub
		return this.personaJpaRepository.buscarPorCedulaNamedNative(cedula);
	}
	
	@Override
	public Persona buscarPorCedulaCriteriaApi(String cedula) {
		// TODO Auto-generated method stub
		return this.personaJpaRepository.buscarPorCedulaCriteriaApi(cedula);
	}
	
	@Override
	public Persona buscarDinamicamente(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		return this.personaJpaRepository.buscarDinamicamente(nombre, apellido, genero);
	}
	
	@Override
	public Persona buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.personaJpaRepository.buscarPorId(id);
	}

	@Override
	public void actualizar(Persona p) {
		// TODO Auto-generated method stub
		this.personaJpaRepository.actualizar(p);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.personaJpaRepository.eliminar(id);
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		// TODO Auto-generated method stub
		return this.personaJpaRepository.actualizarPorApellido(genero, apellido);
	}
	
	@Override
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.personaJpaRepository.buscarPorNombreApellido(nombre, apellido);
	}

	@Override
	public int eliminarPorGenero(String genero) {
		// TODO Auto-generated method stub
		return this.personaJpaRepository.eliminarPorGenero(genero);
	}
	
}
