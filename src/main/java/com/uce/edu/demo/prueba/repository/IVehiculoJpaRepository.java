package com.uce.edu.demo.prueba.repository;

import com.uce.edu.demo.prueba.modelo.Vehiculo;

public interface IVehiculoJpaRepository {
	public void insertar(Vehiculo v);
	public Vehiculo buscarPorPlaca(String placa);
	public void actualizar(Vehiculo v);
	public void eliminar(String placa);
}
