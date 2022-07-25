package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Artista;

@Repository
@Transactional
public class ArtistaRepositoryImpl implements IArtistaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Artista artista) {
		// TODO Auto-generated method stub
		this.entityManager.persist(artista);
	}

	@Override
	public Artista buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT a FROM Artista a WHERE a.nombre = :datoNombre");
		myQuery.setParameter("datoNombre", nombre);
		return (Artista) myQuery.getSingleResult();
	}

	@Override
	public void actualizar(Artista artista) {
		// TODO Auto-generated method stub
		this.entityManager.merge(artista);
	}

	@Override
	public void eliminar(String nombre) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorNombre(nombre));
	}

}
