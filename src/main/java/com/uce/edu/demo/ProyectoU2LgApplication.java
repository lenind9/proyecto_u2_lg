package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.cajero.repository.modelo.DetalleFactura;
import com.uce.edu.demo.cajero.repository.modelo.Factura;
import com.uce.edu.demo.cajero.service.IFacturaService;

@SpringBootApplication
public class ProyectoU2LgApplication implements CommandLineRunner {
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IFacturaService facturaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU2LgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Factura fact = this.facturaService.consultar(1);
		LOG.info("Numero: " + fact.getNumero());
		LOG.info("Fecha: " + fact.getFecha());
		
		LOG.info("Cliente: " + fact.getCliente().getNumeroTarjeta());
		
		List<DetalleFactura> detalles = fact.getDetalles();
		for(DetalleFactura deta:detalles) {
			LOG.info("Detalle: " + deta);
		}
		
		
	}

}
