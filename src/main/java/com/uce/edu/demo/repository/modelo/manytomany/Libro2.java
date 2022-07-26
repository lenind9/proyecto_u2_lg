package com.uce.edu.demo.repository.modelo.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "libro2")
public class Libro2 {
	
	@Id
	@Column(name = "lib2_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lib2_id_seq")
	@SequenceGenerator(name = "lib2_id_seq", sequenceName = "lib2_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "lib2_titulo")
	private String titulo;
	
	@Column(name = "lib2_cantidad_paginas")
	private Integer cantidadPaginas;
	
	@OneToMany(mappedBy = "libroId")
	private List<Libro2Autor2> autores;

	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getCantidadPaginas() {
		return cantidadPaginas;
	}

	public void setCantidadPaginas(Integer cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
	}

	public List<Libro2Autor2> getAutores() {
		return autores;
	}

	public void setAutores(List<Libro2Autor2> autores) {
		this.autores = autores;
	}
	
}
