package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.service.IEstudianteJdbcService;
import com.uce.edu.demo.service.IPersonaJdbcService;
import com.uce.edu.demo.to.Estudiante;

@SpringBootApplication
public class ProyectoU2LgApplication implements CommandLineRunner {
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IEstudianteJdbcService iEstudianteJdbcService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2LgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Estudiante estudiante = new Estudiante();
		estudiante.setId(9);
		estudiante.setCedula("1732246824");
		estudiante.setNombre("Nicolas");
		estudiante.setApellido("Lema");
		estudiante.setMaterias("5");
		
		//Insertar
		//this.iEstudianteJdbcService.guardar(estudiante);
		
		Estudiante estudiante1= new Estudiante();
		estudiante1.setId(8);
		estudiante1.setCedula("1721433398");
		estudiante1.setNombre("Pedro");
		estudiante1.setApellido("Benavides");
		estudiante1.setMaterias("6");
		
		//Actualizar
		//this.iEstudianteJdbcService.actualizar(estudiante1);
		
		//Eliminar
		//this.iEstudianteJdbcService.eliminar(2);
		
		//Buscar
		LOG.info(this.iEstudianteJdbcService.buscar(9));
	}

}
