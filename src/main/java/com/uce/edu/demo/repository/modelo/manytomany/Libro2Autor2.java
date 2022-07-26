package com.uce.edu.demo.repository.modelo.manytomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "libro2_autor2")
public class Libro2Autor2 {
	
	@Id
	@Column(name = "auli_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auli_id_seq")
	@SequenceGenerator(name = "auli_id_seq", sequenceName = "auli_id_seq", allocationSize = 1)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor2 autorId;
	
	@ManyToOne
	@JoinColumn(name = "libro_id")
	private Libro2 libroId;

	//SET y GET
	public Autor2 getAutorId() {
		return autorId;
	}

	public void setAutorId(Autor2 autorId) {
		this.autorId = autorId;
	}

	public Libro2 getLibroId() {
		return libroId;
	}

	public void setLibroId(Libro2 libroId) {
		this.libroId = libroId;
	}
	
}
