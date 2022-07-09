package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		
		//Actualizar con JPQL
		int resultado = this.personaJpaService.actualizarPorApellido("FE", "Teran");
		LOG.info("Cantidad de registros actualizados: " + resultado);
		
		//Eliminar con JPQL
		int resultado2 = this.personaJpaService.eliminarPorGenero("FE");
		LOG.info("Cantidad de eliminados: " + resultado2);
		
	}

}
