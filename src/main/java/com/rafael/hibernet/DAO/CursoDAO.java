package com.rafael.hibernet.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.rafael.hibernet.Interface.ICursoDAO;
import com.rafael.hibernet.Modelo.Curso;
import com.rafael.hibernet.Modelo.HibernateUtil;

public class CursoDAO implements ICursoDAO {

	private Session session;
	public String mess = "";

	public CursoDAO() {
		try {
			session = HibernateUtil.getSession();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	@Override
	public List<Curso> findAll() {

		List<Curso> ListaCurso = null;

		session = HibernateUtil.getSession();
		try {
			ListaCurso = session.createQuery("from Curso").list();
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			mess = ex.getMessage();
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
		return ListaCurso;
	}

	@Override
	public Curso find(int id) {
		Curso curso= null;

		session = HibernateUtil.getSession();
		try {
			curso = (Curso) session.find(Curso.class,id);
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			mess = ex.getMessage();
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
		return curso;
	}

	@Override
	public boolean create(Curso curso) {

		session = HibernateUtil.getSession();
		System.out.println("asdadsasdasd");
		try {
			session.save(curso);			
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			mess = ex.getMessage();
			session.getTransaction().rollback();
			ex.printStackTrace();
			System.out.print(mess);
			return false;
		}
		return true;
	}

	@Override
	public boolean update(Curso curso) {

		session = HibernateUtil.getSession();
		try {
			session.merge(curso);			
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			mess = ex.getMessage();
			session.getTransaction().rollback();
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(int id) {

		Curso curso = null;

		session = HibernateUtil.getSession();
		try {
			curso = session.find(Curso.class, id);
			session.delete(curso);			
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			mess = ex.getMessage();
			session.getTransaction().rollback();
			ex.printStackTrace();
			return false;
		}
		return true;
	}

}
