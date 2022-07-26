package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ILibro2Repository;
import com.uce.edu.demo.repository.modelo.manytomany.Libro2;

@Service
public class Libro2ServiceImpl implements ILibro2Service {
	
	@Autowired
	private ILibro2Repository libro2Repository;

	@Override
	public void insertar(Libro2 libro) {
		// TODO Auto-generated method stub
		this.libro2Repository.insertar(libro);
	}
}
