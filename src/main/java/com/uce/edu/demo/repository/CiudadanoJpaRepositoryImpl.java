package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Ciudadano;

@Repository
@Transactional
public class CiudadanoJpaRepositoryImpl implements ICiudadanoJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Ciudadano c) {
		// TODO Auto-generated method stub
		this.entityManager.persist(c);
	}
	
}
