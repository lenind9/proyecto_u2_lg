package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Persona;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2LgApplication implements CommandLineRunner {
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IPersonaJpaService personaJpaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2LgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//LOG.info("Lista: " + this.iPersonaJdbcService.buscarTodos());
		//Buscar
		LOG.info("Dato con JPA: " + personaJpaService.buscarPorId(5));
		Persona per = new Persona();
		per.setId(6);
		per.setNombre("Nicolas");
		per.setApellido("Lema");
		
		//Insertar
		//this.personaJpaService.guardar(per);
		Persona per1 = new Persona();
		per1.setId(6);
		per1.setNombre("Nicole");
		per1.setApellido("Sanchez");
		
		//Actualizar
		//this.personaJpaService.actualizar(per1);
		
		//Eliminar
		this.personaJpaService.eliminar(7);
	}

}
