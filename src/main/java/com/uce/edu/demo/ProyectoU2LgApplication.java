package com.uce.edu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Persona;

//import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;

@SpringBootApplication
public class ProyectoU2LgApplication implements CommandLineRunner {
	
	//private static final Logger LOG= LoggerFactory.getLogger(ProyectoU2LgApplication.class);
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IPersonaJdbcService iPersonaJdbcService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2LgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Persona persona = new Persona();
		persona.setId(4);
		persona.setNombre("David");
		persona.setApellido("Coronel");
		
		//Insertar
		//this.iPersonaJdbcService.guardar(persona);
		
		Persona persona1 = new Persona();
		persona1.setId(5);
		persona1.setNombre("Daniel");
		persona1.setApellido("Chavez");

		//Actualizar
		//this.iPersonaJdbcService.actualizar(persona1);
		
		//Eliminar
		//this.iPersonaJdbcService.eliminar(4);
		
		//Buscar
		LOG.info(this.iPersonaJdbcService.buscar(5));
	}

}
