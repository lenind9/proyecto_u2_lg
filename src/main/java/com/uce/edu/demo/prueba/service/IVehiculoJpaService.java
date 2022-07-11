package com.uce.edu.demo.prueba.service;

import com.uce.edu.demo.prueba.modelo.Vehiculo;

public interface IVehiculoJpaService {
	
	public void insertarVehiculo(Vehiculo v);
	public Vehiculo buscarVehiculo(String placa);
	public void actualizarVehiculo(Vehiculo v);
	public void borrarVehiculo(String placa);
	
}
