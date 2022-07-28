package com.uce.edu.demo.prueba.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {
	
	@Id	
	@Column(name = "vehi_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehi_seq_id")
	@SequenceGenerator(name = "vehi_seq_id", sequenceName = "vehi_seq_id", allocationSize = 1)
	private Integer id;
	
	@Column(name = "vehi_marca")
	private String marca;
	
	@Column(name = "vehi_modelo")
	private String modelo;
	
	@Column(name = "vehi_placa")
	private String placa;
	
	@Column(name = "vehi_tipo")
	private String tipo;
	
	@Column(name = "vehi_precio")
	private BigDecimal precio;
	
	@OneToOne(mappedBy = "vehiculo")
	private Matricula matricula;
	
	@Override
	public String toString() {
		return "Vehiculo [marca=" + marca + ", modelo=" + modelo + ", placa=" + placa + ", tipo=" + tipo + ", precio="
				+ precio + "]";
	}
	
	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	
}
