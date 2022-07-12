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
		
		Persona per1 = new Persona();
		per1.setApellido("Velez");
		per1.setNombre("Daniel");
		per1.setCedula("1784664212");
		per1.setGenero("M");
		//this.personaJpaService.guardar(per1);
		
		//1 TypedQuery
		Persona perTyped = this.personaJpaService.buscarPorCedulaTyped("1745001323");
		LOG.info("Persona Typed: " + perTyped);
		
		//2 NamedQuery
		Persona perNamed = this.personaJpaService.buscarPorCedulaNamed("1745001323");
		LOG.info("Persona Named: " + perNamed);
		
		//3 TypedQuery y NamedQuery
		Persona perTypedNamed = this.personaJpaService.buscarPorCedulaTypedNamed("1745001323");
		LOG.info("Persona TypedNamed: " + perTypedNamed);
		
		//4 Varios NamedQuery
		List<Persona> listaPersona = this.personaJpaService.buscarPorNombreApellido("Daniel", "Velez");
		for(Persona item:listaPersona) {
			LOG.info("Persona: " + item);
		}
		
	}

}
