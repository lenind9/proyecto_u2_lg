package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

	@Override
	public Ciudadano buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT c FROM Ciudadano c WHERE c.cedula = :datoCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Ciudadano)myQuery.getSingleResult();
	}

	@Override
	public void actualizar(Ciudadano c) {
		// TODO Auto-generated method stub
		this.entityManager.merge(c);
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		Ciudadano ciudadano = this.buscarPorCedula(cedula);
		this.entityManager.remove(ciudadano);
	}
	
}
