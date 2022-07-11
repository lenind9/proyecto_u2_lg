package com.uce.edu.demo.prueba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba.modelo.Vehiculo;
import com.uce.edu.demo.prueba.repository.IVehiculoJpaRepository;

@Service
public class VehiculoJpaServiceImpl implements IVehiculoJpaService {
	
	@Autowired
	private IVehiculoJpaRepository vehiculoJpaRepository;

	@Override
	public void insertarVehiculo(Vehiculo v) {
		// TODO Auto-generated method stub
		this.vehiculoJpaRepository.insertar(v);
	}

	@Override
	public Vehiculo buscarVehiculo(String placa) {
		// TODO Auto-generated method stub
		return this.vehiculoJpaRepository.buscarPorPlaca(placa);
	}

	@Override
	public void actualizarVehiculo(Vehiculo v) {
		// TODO Auto-generated method stub
		this.vehiculoJpaRepository.actualizar(v);
	}

	@Override
	public void borrarVehiculo(String placa) {
		// TODO Auto-generated method stub
		this.vehiculoJpaRepository.eliminar(placa);
	}

}
