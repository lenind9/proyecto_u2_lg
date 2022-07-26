package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.manytomany.Libro2Autor2;

@Repository
@Transactional
public class Libro2Autor2RepositoryImpl implements ILibro2Autor2Repository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Libro2Autor2 libro2Autor2) {
		// TODO Auto-generated method stub
		this.entityManager.persist(libro2Autor2);
	}
	
}
