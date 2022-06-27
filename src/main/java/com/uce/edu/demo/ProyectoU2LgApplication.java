package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoU2LgApplication implements CommandLineRunner {
	
	Logger Logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2LgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hola mundo");
		//Configuracion de logs //log4j
		Logger.fatal("Fatal");
	}

}
