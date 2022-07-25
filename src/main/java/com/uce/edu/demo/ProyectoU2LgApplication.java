package com.uce.edu.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.onetomany.Artista;
import com.uce.edu.demo.service.IAlbumService;
import com.uce.edu.demo.service.IArtistaService;

@SpringBootApplication
public class ProyectoU2LgApplication implements CommandLineRunner {
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IArtistaService artistaService;
	
	@Autowired
	private IAlbumService albumService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2LgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Insertar
		Artista artista = new Artista();
		artista.setNombre("Lorna Shore");
		artista.setOrigen("Phillisburg, Nueva Jersey");
		artista.setEstado("Retirado");
		
		this.artistaService.insertar(artista);
		
		//Buscar album por numero
		/*Artista arti1 = new Artista();
		arti1.setId(2);
		
		Album albu1 = new Album();
		albu1.setNombre("Lateralus");
		albu1.setGenero("Metal progresivo");
		albu1.setDuración("78:51");
		albu1.setArtista(arti1);
		
		Album albu2 = new Album();
		albu2.setNombre("10,000 Days");
		albu2.setGenero("Metal progresivo");
		albu2.setDuración("75:45");
		albu2.setArtista(arti1);
		
		this.albumService.insertar(albu1);
		this.albumService.insertar(albu2);*/
		
		//Buscar
		Artista arti = this.artistaService.buscarPorNombre("Tool");
		LOG.info("Artista encontrado: " + arti);
		
		//Actualizar
		Artista artista2 = new Artista();
		artista2.setId(3);
		artista2.setNombre("Lorna Shore");
		artista2.setOrigen("Phillisburg, Nueva Jersey");
		artista2.setEstado("Activo");
		
		this.artistaService.actualizar(artista2);
		
		//Eliminar
		this.artistaService.eliminar("Tool");
	}

}
