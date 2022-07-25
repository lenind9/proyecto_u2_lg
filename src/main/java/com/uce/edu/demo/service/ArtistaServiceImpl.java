package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IArtistaRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Artista;

@Service
public class ArtistaServiceImpl implements IArtistaService {
	
	@Autowired
	private IArtistaRepository artistaRepository;
	
	@Override
	public void insertar(Artista artista) {
		// TODO Auto-generated method stub
		this.artistaRepository.insertar(artista);
	}

	@Override
	public Artista buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.artistaRepository.buscarPorNombre(nombre);
	}

	@Override
	public void actualizar(Artista artista) {
		// TODO Auto-generated method stub
		this.artistaRepository.actualizar(artista);
	}

	@Override
	public void eliminar(String nombre) {
		// TODO Auto-generated method stub
		this.artistaRepository.eliminar(nombre);
	}

}
