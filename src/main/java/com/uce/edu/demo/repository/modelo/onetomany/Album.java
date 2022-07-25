package com.uce.edu.demo.repository.modelo.onetomany;

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
@Table(name = "album")
public class Album {
	
	@Id
	@Column(name = "albu_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "albu_id_seq")
	@SequenceGenerator(name = "albu_id_seq", sequenceName = "albu_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "albu_nombre")
	private String nombre;
	
	@Column(name = "albu_genero")
	private String genero;
	
	@Column(name = "albu_duracion")
	private String duración;
	
	@ManyToOne
	@JoinColumn(name = "albu_id_artista")
	private Artista artista;
	
	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDuración() {
		return duración;
	}

	public void setDuración(String duración) {
		this.duración = duración;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	
}
