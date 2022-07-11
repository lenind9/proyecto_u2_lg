package com.uce.edu.demo.prueba.service;

import com.uce.edu.demo.prueba.modelo.Propietario;

public interface IPropietarioJpaService {
	
	public void insertarPropietario(Propietario p);
	public void borrarPropietario(String cedula);
	
}
