package com.uce.edu.demo.repository.modelo.onetomany;

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
@Table(name = "artista")
public class Artista {
	
	@Id
	@Column(name = "arti_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "arti_id_seq")
	@SequenceGenerator(name = "arti_id_seq", sequenceName = "arti_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "arti_nombre")
	private String nombre;
	
	@Column(name = "arti_origen")
	private String origen;
	
	@Column(name = "arti_estado")
	private String estado;
	
	@OneToMany(mappedBy = "artista")
	private List<Album> albumes;
	
	@Override
	public String toString() {
		return "Artista [id=" + id + ", nombre=" + nombre + ", origen=" + origen + ", estado=" + estado + "]";
	}

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

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Album> getAlbumes() {
		return albumes;
	}

	public void setAlbumes(List<Album> albumes) {
		this.albumes = albumes;
	}
	
}
