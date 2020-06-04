package com.rafael.hibernet.Interface;

import java.util.List;

import com.rafael.hibernet.Modelo.TbAlumno;

public interface IAlumno {

	List<TbAlumno> findAll();
	TbAlumno find(int id);
	boolean create(TbAlumno alumno);
	boolean update(TbAlumno alumno);
	boolean delete(int id);
	
	List<TbAlumno> findByNombreOrApllido(String prmCadena, String prmTipo);
}
