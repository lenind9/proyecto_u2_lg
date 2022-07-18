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

import com.uce.edu.demo.repository.modelo.Persona;

@Repository
@Transactional
public class PersonaJpaRepositoryImpl implements IPersonaJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Persona p) {
		// TODO Auto-generated method stub
		this.entityManager.persist(p);
	}
	
	@Override
	public List<Persona> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre = :datoNombre");
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Persona> buscarPorGenero(String genero) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.genero = :datoGenero");
		myQuery.setParameter("datoGenero", genero);
		return myQuery.getResultList();
	}

	@Override
	public List<Persona> buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Persona> buscarPorNombreApellido(String nombre, String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorNombreApellido", Persona.class);
		myQuery.setParameter("datoNombre", nombre);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}
	
	@Override
	public Persona buscarPorCedula(String cedula) {
		// SELECT * FROM persona WHERE pers_cedula = '1721330451';
		Query jpqlQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula = :datoCedula");
		jpqlQuery.setParameter("datoCedula", cedula);
		return (Persona)jpqlQuery.getSingleResult();
	}
	
	@Override
	public Persona buscarPorCedulaTyped(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> miTypedQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.cedula = :datoCedula", Persona.class);
		miTypedQuery.setParameter("datoCedula", cedula);
		return miTypedQuery.getSingleResult();
	}
	
	@Override
	public Persona buscarPorCedulaNamed(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula");
		myQuery.setParameter("datoCedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}
	
	@Override
	public Persona buscarPorCedulaTypedNamed(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedula", Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}
	
	@Override
	public Persona buscarPorCedulaNative(String cedula) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNativeQuery("SELECT * FROM persona WHERE pers_cedula = :datoCedula", Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return (Persona) myQuery.getSingleResult();
	}
	
	@Override
	public Persona buscarPorCedulaNamedNative(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Persona> myQuery = this.entityManager.createNamedQuery("Persona.buscarPorCedulaNative", Persona.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}
	
	@Override
	public Persona buscarPorCedulaCriteriaApi(String cedula) {
		// TODO Auto-generated method stub
		//SELECT * FROM Persona p WHERE p.cedula = :datoCedula
		//Creamos una instancia de la interfaz CriteriaBuilder Fabrica para construir el SQL
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		
		//Especificamos el retorno de mi SQL
		CriteriaQuery<Persona> myQuery = myBuilder.createQuery(Persona.class);
		
		//Aqui empezamos a construir el SQL
		//Root o FROM
		Root<Persona> personaFrom = myQuery.from(Persona.class); //FROM Persona
		//myQuery.select(personaFrom); //SELECT p FROM
		//Las condiciones where en Criteria API se los conoce como predicados
		Predicate p1 = myBuilder.equal(personaFrom.get("cedula"), cedula); //p.cedula = :datoCedula
		
		myQuery.select(personaFrom).where(p1);
		
		//Finalizado mi query completo
		TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQuery);
		return myQueryFinal.getSingleResult();
	}
	
	@Override
	public Persona buscarDinamicamente(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder(); //Constructor
		CriteriaQuery<Persona> myQuery = myCriteria.createQuery(Persona.class);
		
		Root<Persona> myTabla = myQuery.from(Persona.class);
		
		//pers_nombre = 'Diana'
		Predicate predicadoNombre = myCriteria.equal(myTabla.get("nombre"), nombre); //(nombre de la entidad, nombre de parametro)
		//pers_apellido = 'Muñoz'
		Predicate predicateApellido = myCriteria.equal(myTabla.get("apellido"), apellido);
		
		//pers_nombre = 'Diana' and pers_apellido = 'Muñoz'
		Predicate miPredicadoFinal = null;
		if(genero.equals("M")) {
			miPredicadoFinal = myCriteria.and(predicadoNombre, predicateApellido);
		} else {
			miPredicadoFinal = myCriteria.or(predicadoNombre, predicateApellido);
		}
		myQuery.select(myTabla).where(miPredicadoFinal);
		
		TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQuery);
		return myQueryFinal.getSingleResult();
	}
	
	@Override
	public Persona buscarDinamicamentePredicados(String nombre, String apellido, String genero) {
		// TODO Auto-generated method stub
		CriteriaBuilder myCriteria = this.entityManager.getCriteriaBuilder();
	    CriteriaQuery<Persona> myQuery = myCriteria.createQuery(Persona.class);
	    Root<Persona> myTable = myQuery.from(Persona.class);
	    
	    Predicate predicateNombre = myCriteria.equal(myTable.get("nombre"), nombre);
	    Predicate predicateApellido = myCriteria.equal(myTable.get("apellido"), apellido);
	    Predicate predicateGenero = myCriteria.equal(myTable.get("genero"), genero);

	    //pers_nombre = 'Diana' and pers_apellido = 'Muñoz'
	    Predicate myPredicateFinal = null;
	    if (genero.equals("M")) {
	        //Predicate predicateFecha = myCriteria.equal(myTable.get("cedula"),"cedula"); como ejemplo, se puede añadir mas condiciones despues
	        myPredicateFinal = myCriteria.or(predicateNombre,predicateApellido);
	        myPredicateFinal = myCriteria.and(myPredicateFinal, predicateGenero); //nombre o apellido y genero
	    }else if (genero.equals("F")) {
	        myPredicateFinal = myCriteria.and(predicateNombre, predicateApellido);
	        myPredicateFinal = myCriteria.or(myPredicateFinal, predicateGenero); //nombre y apellido o genero
	    }

	    myQuery.select(myTable).where(myPredicateFinal);
	    TypedQuery<Persona> myQueryFinal = this.entityManager.createQuery(myQuery);

	    return myQueryFinal.getSingleResult();
	}

	@Override
	public Persona buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Persona.class, id);
	}

	@Override
	public void actualizar(Persona p) {
		// TODO Auto-generated method stub
		this.entityManager.merge(p);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Persona persona = this.buscarPorId(id);
		this.entityManager.remove(persona);
	}

	@Override
	public int actualizarPorApellido(String genero, String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("UPDATE Persona p SET p.genero = :datoGenero WHERE p.apellido = :datoApellido");
		myQuery.setParameter("datoGenero", genero);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.executeUpdate();
	}
	
	@Override
	public int eliminarPorGenero(String genero) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("DELETE FROM Persona p WHERE p.genero = :genero");
		myQuery.setParameter("genero", genero);
		return myQuery.executeUpdate();
	}
	
}
