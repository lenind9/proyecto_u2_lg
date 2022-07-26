package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IAutorRepository;
import com.uce.edu.demo.repository.modelo.manytomany.Autor;

@Service
public class AutorServiceImpl implements IAutorService {
	
	@Autowired
	private IAutorRepository autorRepository;
	
	@Override
	public void insertar(Autor autor) {
		// TODO Auto-generated method stub
		this.autorRepository.insertar(autor);
	}

}
