package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Ciudadano;
import com.uce.edu.demo.repository.modelo.Empleado;
import com.uce.edu.demo.repository.modelo.Pasaporte;
import com.uce.edu.demo.service.ICiudadanoJpaService;

@SpringBootApplication
public class ProyectoU2LgApplication implements CommandLineRunner {
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private ICiudadanoJpaService ciudadanoJpaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2LgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Ciudadano ciu1 = new Ciudadano();
		ciu1.setNombre("Daniel");
		ciu1.setApellido("Sanchez");
		
		Empleado empl1 = new Empleado();
		empl1.setCodigoIess("45774152");
		empl1.setSalario(new BigDecimal(175));
		empl1.setCiudadano(ciu1);
		
		ciu1.setEmpleado(empl1);
		
		this.ciudadanoJpaService.insertar(ciu1);*/
		
		//Insertar
		Ciudadano ciu1 = new Ciudadano();
		ciu1.setNombre("Samuel");
		ciu1.setApellido("Ramirez");
		ciu1.setCedula("1799896589");
		ciu1.setFechaNacimiento(LocalDateTime.of(2000, 12, 8, 23, 5));
		
		Pasaporte pasa1 = new Pasaporte();
		pasa1.setNumero("846552154");
		pasa1.setFechaEmision(LocalDateTime.of(2019, 7, 14, 10, 7));
		pasa1.setFechaCaducidad(LocalDateTime.of(2024, 6, 20, 20, 0));
		pasa1.setCiudadano(ciu1);
		
		ciu1.setPasaporte(pasa1);
		
		this.ciudadanoJpaService.insertar(ciu1);
		
		//Buscar
		Ciudadano c = this.ciudadanoJpaService.buscarPorCedula("1778010209");
		LOG.info("Ciudadano encontrado: " + c);
		
		//Actualizar
		Ciudadano ciu2 = new Ciudadano();
		ciu2.setId(10);
		ciu2.setNombre("Francisca");
		ciu2.setApellido("Jimenez");
		ciu2.setCedula("1778010209");
		ciu2.setFechaNacimiento(LocalDateTime.of(2000, 12, 8, 23, 5));
		
		this.ciudadanoJpaService.actualizar(ciu2);
		
		//Eliminar
		this.ciudadanoJpaService.eliminar("1710399879");
		
	}

}
