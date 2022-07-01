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
		
		Estudiante est = new Estudiante();
		est.setId(6);
		est.setCedula("1717452203");
		est.setNombre("Juan");
		est.setApellido("Jimenez");
		est.setMaterias("3");
		
		//Insertar
		this.estudianteJpaService.guardar(est);
		
		//Buscar
		LOG.info(estudianteJpaService.buscarPorId(9));
		
		Estudiante est1 = new Estudiante();
		est1.setId(6);
		est1.setCedula("1717542023");
		est1.setNombre("Alberto");
		est1.setApellido("Ramirez");
		est1.setMaterias("4");
		
		//Actualizar
		this.estudianteJpaService.actualizar(est1);
		
		//Eliminar
		this.estudianteJpaService.eliminar(5);
		
	}

}
