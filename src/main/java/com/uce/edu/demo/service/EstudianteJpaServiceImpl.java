package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IEstudianteJpaRepository;
import com.uce.edu.demo.repository.modelo.Estudiante;

@Service
public class EstudianteJpaServiceImpl implements IEstudianteJpaService {
	
	@Autowired
	private IEstudianteJpaRepository estudianteJpaRepository;
	
	@Override
	public void guardar(Estudiante e) {
		// TODO Auto-generated method stub
		this.estudianteJpaRepository.insertar(e);
	}
	
	@Override
	public Estudiante buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorId(id);
	}
	
	@Override
	public Estudiante buscarPorCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorCedulaTyped(cedula);
	}

	@Override
	public Estudiante buscarPorMateriasTyped(String materias) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorMateriasTyped(materias);
	}

	@Override
	public Estudiante buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorCedulaNamed(cedula);
	}

	@Override
	public Estudiante buscarPorMateriasNamed(String materias) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorMateriasNamed(materias);
	}

	@Override
	public Estudiante buscarPorCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorCedulaTypedNamed(cedula);
	}

	@Override
	public List<Estudiante> buscarPorNombreApellidoTypedNamed(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorNombreApellidoTypedNamed(nombre, apellido);
	}
	
	@Override
	public Estudiante buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorCedulaNative(cedula);
	}

	@Override
	public Estudiante buscarPorApellidoNative(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorApellidoNative(apellido);
	}

	@Override
	public Estudiante buscarPorCedulaNamedNative(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorCedulaNamedNative(cedula);
	}

	@Override
	public Estudiante buscarPorApellidoNamedNative(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarPorApellidoNamedNative(apellido);
	}
	
	@Override
	public List<Estudiante> buscarDinamicamente(String nombre, String apellido, Integer materias) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarDinamicamente(nombre, apellido, materias);
	}

	@Override
	public List<Estudiante> buscarDinamicamentePredicados(String nombre, String apellido, Integer materias) {
		// TODO Auto-generated method stub
		return this.estudianteJpaRepository.buscarDinamicamentePredicados(nombre, apellido, materias);
	}
	
	
	@Override
	public void actualizar(Estudiante e) {
		// TODO Auto-generated method stub
		this.estudianteJpaRepository.actualizar(e);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteJpaRepository.eliminar(id);
	}
	
}
