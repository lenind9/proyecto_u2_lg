package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Estudiante;
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
		
		Estudiante est1 = new Estudiante();
		est1.setApellido("Lema");
		est1.setNombre("Nicolas");
		est1.setCedula("1750364499");
		est1.setMaterias("2");
		//this.estudianteJpaService.guardar(est1);
		
		//TypedQuery
		//1
		Estudiante estTyped1 = this.estudianteJpaService.buscarPorCedulaTyped("1721433398");
		LOG.info("Estudiante Typed 1: " + estTyped1);
		
		//2
		Estudiante estTyped2 = this.estudianteJpaService.buscarPorMateriasTyped("5");
		LOG.info("Estudiante Typed 2: " + estTyped2);
		
		//NamedQuery
		//1
		Estudiante estNamed1 = this.estudianteJpaService.buscarPorCedulaNamed("1721433398");
		LOG.info("Estudiante Named 1: " + estNamed1);
		
		//2
		Estudiante estNamed2 = this.estudianteJpaService.buscarPorMateriasNamed("5");
		LOG.info("Estudiante Named 2: " + estNamed2);
		
		//Typed y Named
		//1
		Estudiante estTypedNamed = this.estudianteJpaService.buscarPorCedulaTypedNamed("1721433398");
		LOG.info("Estudiante TypedNamed 1: " + estTypedNamed);
		
		//2
		List<Estudiante> listaEstudiante = this.estudianteJpaService.buscarPorNombreApellidoTypedNamed("Nicolas", "Lema");
		for(Estudiante item:listaEstudiante) {
			LOG.info("Estudiante TypedNamed 2: " + item);
		}
		
	}

}
