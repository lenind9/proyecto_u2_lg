package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.EstudianteContadorMateriasPares;
import com.uce.edu.demo.repository.modelo.EstudianteSencillo;

@Repository
@Transactional
public class EstudianteJpaRepositoryImpl implements IEstudianteJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Estudiante e) {
		// TODO Auto-generated method stub
		this.entityManager.persist(e);
	}

	@Override
	public Estudiante buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Estudiante.class, id);
	}
	
	@Override
	public Estudiante buscarPorCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula = :datoCedula ORDER BY e.apellido ASC", Estudiante.class);
		myTypedQuery.setParameter("datoCedula", cedula);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorMateriasTyped(String materias) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.materias = :datoMaterias ORDER BY e.nombre ASC", Estudiante.class);
		myTypedQuery.setParameter("datoMaterias", materias);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorMateriasNamed(String materias) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorMaterias");
		myQuery.setParameter("datoMaterias", materias);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorCedula", Estudiante.class);
		myTypedQuery.setParameter("datoCedula", cedula);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> buscarPorNombreApellidoTypedNamed(String nombre, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombreApellido", Estudiante.class);
		myTypedQuery.setParameter("datoNombre", nombre);
		myTypedQuery.setParameter("datoApellido", apellido);
		return myTypedQuery.getResultList();
	}
	
	@Override
	public List<EstudianteSencillo> buscarPorNombreSencillo(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<EstudianteSencillo> myQuery = this.entityManager.createQuery("SELECT NEW com.uce.edu.demo.repository.modelo.EstudianteSencillo(e.nombre, e.apellido) FROM Estudiante e WHERE e.nombre = :datoNombre", EstudianteSencillo.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}

	@Override
	public List<EstudianteContadorMateriasPares> buscarPorMateriasPares() {
		// TODO Auto-generated method stub
		//SELECT estu_materias, COUNT(estu_materias) FROM estudiante GROUP BY estu_materias HAVING estu_materias % 2 = 0
		TypedQuery<EstudianteContadorMateriasPares> myQuery = this.entityManager.createQuery("SELECT NEW com.uce.edu.demo.repository.modelo.EstudianteContadorMateriasPares(e.materias, COUNT(e.materias)) FROM Estudiante e GROUP BY e.materias HAVING materias % 2 = 0", EstudianteContadorMateriasPares.class);
		return myQuery.getResultList();
	}
	
	@Override
	public Estudiante buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE estu_cedula = :datoCedula", Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorApellidoNative(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM estudiante WHERE estu_apellido = :datoApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorCedulaNamedNative(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorCedulaNative", Estudiante.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante buscarPorApellidoNamedNative(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellido", Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}
	
	@Override
	public List<Estudiante> buscarDinamicamente(String nombre, String apellido, Integer materias) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = myCriteria.createQuery(Estudiante.class);
		
		Root<Estudiante> myTabla = myQuery.from(Estudiante.class);
		
		Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre);
		Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);
		
		Predicate miPredicadoFinal = null;
		if(materias % 2 == 0) {
			miPredicadoFinal = myCriteria.and(predicadoNombre, predicadoApellido);
		}else {
			miPredicadoFinal = myCriteria.or(predicadoNombre, predicadoApellido);
		}
		
		myQuery.select(myTabla).where(miPredicadoFinal);
		
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);
		return myQueryFinal.getResultList();
	}

	@Override
	public List<Estudiante> buscarDinamicamentePredicados(String nombre, String apellido, Integer materias) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Estudiante> myQuery = myCriteria.createQuery(Estudiante.class);
		
		Root<Estudiante> myTabla = myQuery.from(Estudiante.class);
		
		Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre);
		Predicate predicadoApellido = myCriteria.equal(myTabla.get("apellido"), apellido);
		Predicate predicadoMaterias = myCriteria.equal(myTabla.get("materias"), materias);
		
		Predicate miPredicadoFinal = null;
		if(materias % 2 == 1) {
			miPredicadoFinal = myCriteria.or(predicadoNombre, predicadoMaterias); 
			miPredicadoFinal = myCriteria.and(miPredicadoFinal, predicadoApellido); //nombre o materias y apellido
		}else {
			miPredicadoFinal = myCriteria.and(predicadoNombre, predicadoMaterias);
			miPredicadoFinal = myCriteria.or(miPredicadoFinal, predicadoApellido); //nombre y materias o apellido
		}
		
		myQuery.select(myTabla).where(miPredicadoFinal);
		
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myQuery);
		return myQueryFinal.getResultList();
	}

	@Override
	public void actualizar(Estudiante e) {
		// TODO Auto-generated method stub
		this.entityManager.merge(e);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarPorId(id));
	}
	
}
