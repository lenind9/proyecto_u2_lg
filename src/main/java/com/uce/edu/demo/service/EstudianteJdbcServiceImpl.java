package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IEstudianteJdbcRepository;
import com.uce.edu.demo.to.EstudianteTo;

@Service
public class EstudianteJdbcServiceImpl implements IEstudianteJdbcService {
	
	@Autowired
	private IEstudianteJdbcRepository iEstudianteJdbcRepository;
	
	@Override
	public void guardar(EstudianteTo e) {
		// TODO Auto-generated method stub
		this.iEstudianteJdbcRepository.insertar(e);
	}

	@Override
	public void actualizar(EstudianteTo e) {
		// TODO Auto-generated method stub
		this.iEstudianteJdbcRepository.actualizar(e);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		this.iEstudianteJdbcRepository.eliminar(id);
	}

	@Override
	public EstudianteTo buscar(int id) {
		// TODO Auto-generated method stub
		return this.iEstudianteJdbcRepository.buscarPorId(id);
	}

}
