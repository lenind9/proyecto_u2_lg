package com.uce.edu.demo.prueba.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "propietario")
public class Propietario {
	
	@Id	
	@Column(name = "prop_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prop_seq_id")
	@SequenceGenerator(name = "prop_seq_id", sequenceName = "prop_seq_id", allocationSize = 1)
	private Integer id;
	
	@Column(name = "prop_nombre")
	private String nombre;
	
	@Column(name = "prop_apellido")
	private String apellido;
	
	@Column(name = "prop_cedula")
	private String cedula;
	
	@OneToOne(mappedBy = "propietario")
	private Matricula matricula;
	
	@Override
	public String toString() {
		return "Propietario [nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + "]";
	}
	
	//SET y GET
	public String getNombre() {
		return nombre;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
}
