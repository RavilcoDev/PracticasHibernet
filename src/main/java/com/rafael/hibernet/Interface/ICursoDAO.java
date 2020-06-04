package com.rafael.hibernet.Interface;

import java.util.List;

import com.rafael.hibernet.Modelo.Curso;

public interface ICursoDAO {

	List<Curso> findAll();
	Curso find(int id);
	boolean create(Curso curso);
	boolean update(Curso curso);
	boolean delete(int id);
}
