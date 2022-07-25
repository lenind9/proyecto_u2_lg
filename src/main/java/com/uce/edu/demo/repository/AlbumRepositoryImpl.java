package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.onetomany.Album;

@Repository
@Transactional
public class AlbumRepositoryImpl implements IAlbumRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Album album) {
		// TODO Auto-generated method stub
		this.entityManager.persist(album);
	}

	@Override
	public Album buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT a FROM Album a WHERE a.nombre = :datoNombre");
		myQuery.setParameter("datoNombre", nombre);
		return (Album) myQuery.getSingleResult();
	}

	@Override
	public void actualizar(Album album) {
		// TODO Auto-generated method stub
		this.entityManager.merge(album);
	}

	@Override
	public void eliminar(String nombre) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorNombre(nombre));
	}
	
}
