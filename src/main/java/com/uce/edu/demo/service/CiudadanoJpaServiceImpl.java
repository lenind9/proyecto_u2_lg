package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICiudadanoJpaRepository;
import com.uce.edu.demo.repository.modelo.onetoone.Ciudadano;

@Service
public class CiudadanoJpaServiceImpl implements ICiudadanoJpaService {

	@Autowired
	private ICiudadanoJpaRepository ciudadanoJpaRepository;
	
	@Override
	public void insertar(Ciudadano c) {
		// TODO Auto-generated method stub
		this.ciudadanoJpaRepository.insertar(c);
	}

	@Override
	public Ciudadano buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.ciudadanoJpaRepository.buscarPorCedula(cedula);
	}

	@Override
	public void actualizar(Ciudadano c) {
		// TODO Auto-generated method stub
		this.ciudadanoJpaRepository.actualizar(c);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		this.ciudadanoJpaRepository.eliminar(cedula);
	}
	
}
