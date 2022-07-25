package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.onetomany.Artista;

public interface IArtistaService {
	public void insertar(Artista artista);
	public Artista buscarPorNombre(String nombre);
	public void actualizar(Artista artista);
	public void eliminar(String nombre);
}
