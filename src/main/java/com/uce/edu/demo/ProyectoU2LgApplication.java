package com.uce.edu.demo;

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
		est1.setApellido("Chavez");
		est1.setNombre("Lisette");
		est1.setCedula("1742216422");
		est1.setMaterias("2");
		//this.estudianteJpaService.guardar(est1);
		
		//NativeQuery
		//1
		Estudiante estNative = this.estudianteJpaService.buscarPorCedulaNative("1742216422");
		LOG.info("Estudiante Native 1: " + estNative);
		
		//2
		estNative = this.estudianteJpaService.buscarPorApellidoNative("Chavez");
		LOG.info("Estudiante Native 2: " + estNative);
		
		//NamedNativeQuery
		//1
		Estudiante estNamedNative = this.estudianteJpaService.buscarPorCedulaNamedNative("1742216422");
		LOG.info("Estudiante Named Native 1: " + estNamedNative);
		
		//2
		estNamedNative = this.estudianteJpaService.buscarPorApellidoNamedNative("Chavez");
		LOG.info("Estudiante Named Native 2: " + estNamedNative);
		
	}

}
