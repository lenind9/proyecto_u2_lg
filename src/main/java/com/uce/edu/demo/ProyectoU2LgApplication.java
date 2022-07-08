package com.uce.edu.demo;

import java.util.List;

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
		
		//Buscar por id
		//LOG.info("Dato con JPA: " + personaJpaService.buscarPorId(5));

		//Insertar
		Persona per = new Persona();
		//per.setId(6);
		per.setNombre("Gustavo");
		per.setApellido("Kanhwald");
		per.setGenero("M");
		per.setCedula("1475456445");
		//this.personaJpaService.guardar(per);
		
		//Actualizar
		Persona per1 = new Persona();
		per1.setId(6);
		per1.setNombre("Nicole");
		per1.setApellido("Sanchez");
		//this.personaJpaService.actualizar(per1);
		
		//Eliminar
		//this.personaJpaService.eliminar(7);
		
		//Buscar por cedula
		Persona  p = this.personaJpaService.buscarPorCedula("1475456445");
		LOG.info("Persona encontrada: " + p);
		
		//Buscar por apellido
		List<Persona> listaPersona = this.personaJpaService.buscarPorApellido("Kanhwald");
		for(Persona item: listaPersona) {
			LOG.info("Persona: " + item);
		}
		
		//Buscar por genero
		List<Persona> listaPersonaGenero = this.personaJpaService.buscarPorGenero("M");
		for(Persona item: listaPersonaGenero) {
			LOG.info("Persona: " + item);
		}
		
		//Buscar por nombre
		List<Persona> listaPersonaNombre = this.personaJpaService.buscarPorNombre("Gustavo");
		for(Persona item: listaPersonaNombre) {
			LOG.info("Persona: " + item);
		}
		
	}

}
