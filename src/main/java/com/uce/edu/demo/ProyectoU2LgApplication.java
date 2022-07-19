package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.EstudianteContadorMateriasPares;
import com.uce.edu.demo.repository.modelo.EstudianteSencillo;
import com.uce.edu.demo.service.IEstudianteJpaService;

@SpringBootApplication
public class ProyectoU2LgApplication implements CommandLineRunner {
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IEstudianteJpaService estudianteJpaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2LgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<EstudianteSencillo> listaEstudiante = this.estudianteJpaService.buscarPorNombreSencillo("Juan");
		for(EstudianteSencillo item:listaEstudiante) {
			LOG.info("Estudiante sencillo: " + item);
		}
		
		List<EstudianteContadorMateriasPares> miListaEstudianteMateriasPares = this.estudianteJpaService.buscarPorMateriasPares();
		for(EstudianteContadorMateriasPares item:miListaEstudianteMateriasPares) {
			LOG.info("Materias Pares: " + item);
		}
		
	}

}
