package com.uce.edu.demo.repository.modelo;

import java.io.Serializable;

public class EstudianteContadorMateriasPares implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer materias;
	private long numero;
	
	public EstudianteContadorMateriasPares() {
		
	}

	public EstudianteContadorMateriasPares(Integer materias, long numero) {
		super();
		this.materias = materias;
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "EstudianteContadorMateriasPares [materias=" + materias + ", numero=" + numero + "]";
	}
	
	//SET y GET
	public Integer getMaterias() {
		return materias;
	}

	public void setMaterias(Integer materias) {
		this.materias = materias;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
