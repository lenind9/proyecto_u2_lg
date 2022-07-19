package com.uce.edu.demo.repository.modelo;

import java.io.Serializable;

public class PersonaContadorGenero implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String genero;
	private long numero;
	
	public PersonaContadorGenero() {
		
	}
	
	public PersonaContadorGenero(String genero, long numero) {
		super();
		this.genero = genero;
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "PersonaContadorGenero [genero=" + genero + ", numero=" + numero + "]";
	}

	//SET y GET
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public long getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}
	
}
