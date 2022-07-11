package com.uce.edu.demo.prueba.repository;

import com.uce.edu.demo.prueba.modelo.Propietario;

public interface IPropietarioJpaRepository {
	public Propietario buscarPorCedula(String cedula);
	public void crear(Propietario p);
	public void eliminar(String cedula);
}
