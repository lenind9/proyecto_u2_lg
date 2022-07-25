package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IAlbumRepository;
import com.uce.edu.demo.repository.modelo.onetomany.Album;

@Service
public class AlbumServiceImpl implements IAlbumService {
	
	@Autowired
	private IAlbumRepository albumRepository;
	
	@Override
	public void insertar(Album album) {
		// TODO Auto-generated method stub
		this.albumRepository.insertar(album);
	}

	@Override
	public Album buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.albumRepository.buscarPorNombre(nombre);
	}

	@Override
	public void actualizar(Album album) {
		// TODO Auto-generated method stub
		this.albumRepository.actualizar(album);
	}

	@Override
	public void eliminar(String nombre) {
		// TODO Auto-generated method stub
		this.albumRepository.eliminar(nombre);
	}
	
}
