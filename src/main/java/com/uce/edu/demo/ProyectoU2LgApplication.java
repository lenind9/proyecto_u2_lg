package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.repository.modelo.DetalleFactura;
import com.uce.edu.demo.cajero.repository.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;
import com.uce.edu.demo.prueba.modelo.Propietario;
import com.uce.edu.demo.prueba.modelo.Vehiculo;
import com.uce.edu.demo.prueba.service.IMatriculaGestorJpaService;
import com.uce.edu.demo.prueba.service.IPropietarioJpaService;
import com.uce.edu.demo.prueba.service.IVehiculoJpaService;

@SpringBootApplication
public class ProyectoU2LgApplication implements CommandLineRunner {
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IVehiculoJpaService vehiculoService;

	@Autowired
	private IPropietarioJpaService propietarioService;

	@Autowired
	private IMatriculaGestorJpaService matriculaGestorService;
	
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
		this.propietarioService.insertarPropietario(p);
		
		//2
		Vehiculo v = new Vehiculo();
		v.setMarca("Toyota");
		v.setModelo("Raize");
		v.setPlaca("PQR-4501");
		v.setPrecio(new BigDecimal(45000));
		v.setTipo("P");
		this.vehiculoService.insertarVehiculo(v);
		
		//3
		v.setPrecio(new BigDecimal(42000));
		this.vehiculoService.actualizarVehiculo(v);
		
		//4
		this.matriculaGestorService.generar("1750418084", "PQR-4501");
		
	}

}
