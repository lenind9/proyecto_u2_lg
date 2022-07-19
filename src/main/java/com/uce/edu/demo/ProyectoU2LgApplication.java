package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.PersonaContadorGenero;
import com.uce.edu.demo.repository.modelo.PersonaSencilla;
import com.uce.edu.demo.service.IEstudianteJpaService;
import com.uce.edu.demo.service.IPersonaJpaService;

@SpringBootApplication
public class ProyectoU2LgApplication implements CommandLineRunner {
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IEstudianteJpaService estudianteJpaService;
	
	@Autowired
	private IPersonaJpaService personaJpaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2LgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		//Criteria API
		//1 nombre o apellido, materia impar
		List<Estudiante> estDinamica = this.estudianteJpaService.buscarDinamicamente("Juan", "Aguilar", 5);
		for(Estudiante item:estDinamica) {
			LOG.info("Estudiante Dinamica: " + item);
		}
		
		//2 nombre y materias o apellido
		List<Estudiante> estDinamicaPredicados = this.estudianteJpaService.buscarDinamicamentePredicados("David", "Chavez", 2);
		for(Estudiante item:estDinamicaPredicados) {
			LOG.info("Estudiante Dinamica Predicados: " + item);
		}*/
		
		List<PersonaSencilla> listaPersona = this.personaJpaService.buscarPorApellidoSencillo("Chavez"); 
		for(PersonaSencilla item:listaPersona) {
			LOG.info("Persona sencilla: " + item);
		}
		
		List<PersonaContadorGenero> miListaPersonaGenero = this.personaJpaService.consultarCantidadPorGenero();
		for(PersonaContadorGenero item:miListaPersonaGenero) {
			LOG.info("Genero: " + item);
		}
		
	}

}
