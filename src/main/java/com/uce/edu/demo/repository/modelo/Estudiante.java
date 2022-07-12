package com.uce.edu.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="estudiante")
@NamedQuery(name = "Estudiante.buscarPorCedula", query = "SELECT e FROM Estudiante e WHERE e.cedula = :datoCedula ORDER BY e.apellido ASC")
@NamedQuery(name = "Estudiante.buscarPorMaterias", query = "SELECT e FROM Estudiante e WHERE e.materias = :datoMaterias ORDER BY e.nombre ASC")
@NamedQuery(name = "Estudiante.buscarPorNombreApellido", query = "SELECT e FROM Estudiante e WHERE e.nombre = :datoNombre AND e.apellido = :datoApellido ORDER BY e.materias DESC")
public class Estudiante {
	
	@Id	
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estu_seq_id")
	@SequenceGenerator(name = "estu_seq_id", sequenceName = "estu_seq_id", allocationSize = 1)
	private Integer id;
	
	@Column(name = "cedula")
	private String cedula;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "materias")
	private String materias;
	
	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", materias=" + materias + "]";
	}
	
	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMaterias() {
		return materias;
	}

	public void setMaterias(String materias) {
		this.materias = materias;
	}
	
}
