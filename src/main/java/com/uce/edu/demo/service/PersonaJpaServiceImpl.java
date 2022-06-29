package com.uce.edu.demo.service;

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

}
