package com.uce.edu.demo.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba.modelo.Propietario;
import com.uce.edu.demo.prueba.repository.IPropietarioJpaRepository;

@Service
public class PropietarioJpaServiceImpl implements IPropietarioJpaService {
	
	@Autowired
	private IPropietarioJpaRepository propietarioJpaRepository;
	
	@Override
	public void insertarPropietario(Propietario p) {
		// TODO Auto-generated method stub
		this.propietarioJpaRepository.crear(p);
	}

	@Override
	public void borrarPropietario(String cedula) {
		// TODO Auto-generated method stub
		this.propietarioJpaRepository.eliminar(cedula);
	}

}
