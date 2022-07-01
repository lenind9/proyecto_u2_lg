package com.uce.edu.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.uce.edu.demo.to.EstudianteTo;

@Repository
public class EstudianteJdbcRepositoryImpl implements IEstudianteJdbcRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertar(EstudianteTo e) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("insert into estudiante (id, cedula, nombre, apellido, materias) values (?, ?, ?, ?, ?)", 
				new Object[] {e.getId(), e.getCedula(), e.getNombre(), e.getApellido(), e.getMaterias()});
	}

	@Override
	public EstudianteTo buscarPorId(int id) {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.queryForObject("select * from estudiante where id=?", new Object[] {id}, new BeanPropertyRowMapper<EstudianteTo>(EstudianteTo.class));
	}

	@Override
	public void actualizar(EstudianteTo e) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("update estudiante set cedula=?, nombre=?, apellido=?, materias=? where id=?", 
				new Object[] {e.getCedula(), e.getNombre(), e.getApellido(), e.getMaterias(), e.getId()});
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.update("delete from estudiante where id=?", new Object[] {id});
	}

}
