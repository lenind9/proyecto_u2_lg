package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.onetoone.Ciudadano;

public interface ICiudadanoJpaRepository {
	public void insertar(Ciudadano c);
	public Ciudadano buscarPorCedula(String cedula);
	public void actualizar(Ciudadano c);
	public void eliminar(String cedula);
}
