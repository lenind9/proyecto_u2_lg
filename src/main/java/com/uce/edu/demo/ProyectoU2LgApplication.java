package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Estudiante;
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
		
		Persona per1 = new Persona();
		per1.setApellido("Lema");
		per1.setNombre("Nicolas");
		per1.setCedula("1741554874");
		per1.setGenero("M");
		//this.personaJpaService.guardar(per1);
		
		//NativeQuery
		Persona perNative = this.personaJpaService.buscarPorCedulaNative("1741554874");
		LOG.info("Persona Native: " + perNative);
		
		Persona perNamedNative = this.personaJpaService.buscarPorCedulaNamedNative("1741554874");
		LOG.info("Persona Named Native: " + perNamedNative);
		
	}

}
