package com.uce.edu.demo.prueba.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.prueba.modelo.Matricula;
import com.uce.edu.demo.prueba.modelo.Propietario;
import com.uce.edu.demo.prueba.modelo.Vehiculo;
import com.uce.edu.demo.prueba.repository.IMatriculaJpaRepository;
import com.uce.edu.demo.prueba.repository.IPropietarioJpaRepository;
import com.uce.edu.demo.prueba.repository.IVehiculoJpaRepository;

@Service
public class MatriculaGestorJpaServiceImpl implements IMatriculaGestorJpaService {
	
	@Autowired
	private IPropietarioJpaRepository iPropietarioJpaRepository;
	
	@Autowired
	private IVehiculoJpaRepository iVehiculoJpaRepository;
	
	@Autowired
	@Qualifier("liviano")
	private IMatriculaJpaService matriculaServiceLiviano;
	
	@Autowired
	@Qualifier("pesado")
	private IMatriculaJpaService matriculaServicePesado;
	
	@Autowired
	public IMatriculaJpaRepository iMatriculaJpaRepository;
	
	@Override
	public void generar(String cedula, String placa) {
		// TODO Auto-generated method stub
		Propietario pro = this.iPropietarioJpaRepository.buscarPorCedula(cedula);
		Vehiculo vehi = this.iVehiculoJpaRepository.buscarPorPlaca(placa);
		String tipo = vehi.getTipo();
		BigDecimal valorMatricula;
		if(tipo.equals("P")) {
			valorMatricula = this.matriculaServicePesado.calcular(vehi.getPrecio());
			
		}else {
			valorMatricula = this.matriculaServiceLiviano.calcular(vehi.getPrecio());
		}
		
		if(valorMatricula.compareTo(new BigDecimal(2000)) > 0) {
			BigDecimal valorDescuento = valorMatricula.multiply(new BigDecimal(7)).divide(new BigDecimal(100));
			valorMatricula = valorMatricula.subtract(valorDescuento);
		}
		Matricula matricula = new Matricula();
		matricula.setFechaMatricula(LocalDateTime.now());
		matricula.setValorMatricula(valorMatricula);
		matricula.setPropietario(pro);
		matricula.setVehiculo(vehi);
		
		this.iMatriculaJpaRepository.crear(matricula);
	}

}
