package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.manytomany.Autor2;
import com.uce.edu.demo.repository.modelo.manytomany.Libro2;
import com.uce.edu.demo.repository.modelo.manytomany.Libro2Autor2;
import com.uce.edu.demo.service.IAutor2Service;
import com.uce.edu.demo.service.ILibro2Autor2Service;
import com.uce.edu.demo.service.ILibro2Service;

@SpringBootApplication
public class ProyectoU2LgApplication implements CommandLineRunner {
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IAutor2Service autor2Service;
	
	@Autowired
	private ILibro2Service libro2Service;
	
	@Autowired
	private ILibro2Autor2Service libro2Autor2Service;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2LgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Insertar 1 libro que tiene dos autores
		Libro2 libro = new Libro2();
		libro.setTitulo("Sueños de piedra");
		libro.setCantidadPaginas(564);
		this.libro2Service.insertar(libro);
		
		Autor2 autor = new Autor2();
		autor.setNombre("Iria Parente");
		this.autor2Service.insertar(autor);
		
		Autor2 autor2 = new Autor2();
		autor2.setNombre("Selene Pascual");
		this.autor2Service.insertar(autor2);
		
		libro.setId(6);
		autor.setId(5);
		autor2.setId(6);
		
		Libro2Autor2 libAu = new Libro2Autor2();
		libAu.setLibroId(libro);
		libAu.setAutorId(autor);
		this.libro2Autor2Service.insertar(libAu);
		
		Libro2Autor2 libAu2 = new Libro2Autor2();
		libAu2.setLibroId(libro);
		libAu2.setAutorId(autor2);
		this.libro2Autor2Service.insertar(libAu2);
		
		
		//Insertar 1 autor que escribió dos libros
		Autor2 autor3 = new Autor2();
		autor3.setNombre("Haruki Murakami");
		this.autor2Service.insertar(autor3);
		
		Libro2 libro2 = new Libro2();
		libro2.setTitulo("Primera persona del singular");
		libro2.setCantidadPaginas(198);
		this.libro2Service.insertar(libro2);
		
		Libro2 libro3 = new Libro2();
		libro3.setTitulo("Tokio blues");
		libro3.setCantidadPaginas(415);
		this.libro2Service.insertar(libro3);
		
		autor3.setId(7);
		libro2.setId(7);
		libro3.setId(8);
		
		Libro2Autor2 libAu3 = new Libro2Autor2();
		libAu3.setAutorId(autor3);
		libAu3.setLibroId(libro2);
		this.libro2Autor2Service.insertar(libAu3);
		
		Libro2Autor2 libAu4 = new Libro2Autor2();
		libAu4.setAutorId(autor3);
		libAu4.setLibroId(libro3);
		this.libro2Autor2Service.insertar(libAu4);
		
	}

}
