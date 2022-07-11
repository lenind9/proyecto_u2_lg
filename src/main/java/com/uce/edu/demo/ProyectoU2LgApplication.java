package com.uce.edu.demo;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.prueba.modelo.Propietario;
import com.uce.edu.demo.prueba.modelo.Vehiculo;
import com.uce.edu.demo.prueba.service.IPropietarioJpaService;
import com.uce.edu.demo.prueba.service.IVehiculoJpaService;

@SpringBootApplication
public class ProyectoU2LgApplication implements CommandLineRunner {
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IVehiculoJpaService vehiculoJpaService;
	
	@Autowired
	private IPropietarioJpaService propietarioJpaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2LgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//1
		Propietario p = new Propietario();
		p.setApellido("Guananga");
		p.setNombre("Lenin");
		p.setCedula("1750418084");
		this.propietarioJpaService.insertarPropietario(p);
		
		//2
		Vehiculo v = new Vehiculo();
		v.setMarca("Toyota");
		v.setModelo("Raize");
		v.setPlaca("PQR-4501");
		v.setPrecio(new BigDecimal(45000));
		v.setTipo("P");
		this.vehiculoJpaService.insertarVehiculo(v);
		
		//3
		v.setPrecio(new BigDecimal(42000));
		this.vehiculoJpaService.actualizarVehiculo(v);
		
	}

}
