package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.onetomany.Album;

public interface IAlbumRepository {
	public void insertar(Album album);
	public Album buscarPorNombre(String nombre);
	public void actualizar(Album album);
	public void eliminar(String nombre);
}
