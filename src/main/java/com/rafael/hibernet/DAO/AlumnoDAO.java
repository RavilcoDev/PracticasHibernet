/**
 * 
 */
package com.rafael.hibernet.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.rafael.hibernet.Interface.IAlumno;
import com.rafael.hibernet.Modelo.HibernateUtil;
import com.rafael.hibernet.Modelo.TbAlumno;

/**
 * @author rafael
 *
 */
public class AlumnoDAO implements IAlumno {

	private Session session;
	public String mess = "";

	public AlumnoDAO() {
		try {
			HibernateUtil utilitario = new HibernateUtil();
			session = utilitario.getSession();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	@Override
	public List<TbAlumno> findAll() {

		List<TbAlumno> ListaCurso = null;

		session = !session.isOpen() ? HibernateUtil.getSession() : session;
		try {
			ListaCurso = (List<TbAlumno>) session.createQuery("from TbAlumno").getResultList();
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			mess = ex.getMessage();
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
		return ListaCurso;
	}

	@Override
	public TbAlumno find(int id) {
		TbAlumno curso = null;

		session = !session.isOpen() ? HibernateUtil.getSession() : session;
		try {
			curso = (TbAlumno) session.find(TbAlumno.class, id);
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			mess = ex.getMessage();
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
		return curso;
	}

	@Override
	public boolean create(TbAlumno curso) {

		session = !session.isOpen() ? HibernateUtil.getSession() : session;
		try {
			session.persist(curso);
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
	public boolean update(TbAlumno curso) {

		session = !session.isOpen() ? HibernateUtil.getSession() : session;
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

		TbAlumno curso = null;

		session = !session.isOpen() ? HibernateUtil.getSession() : session;
		try {
			curso = session.find(TbAlumno.class, id);
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

	@Override
	public List<TbAlumno> findByNombreOrApllido(String prmCadena, String prmTipo) {
		List<TbAlumno> ListaCurso = null;
		String query = "";

		session = !session.isOpen() ? HibernateUtil.getSession() : session;
		try {
			if (prmTipo.equalsIgnoreCase("porNombres")) // filtra por nombres
			{
				query = "from Tbalumno as alumno where alumno.nombre like :buscador";
			} else if (prmTipo.equalsIgnoreCase("porApellidos")) // filtra por apellidos
			{
				query = "from Tbalumno as alumno where alumno.apellido like :buscador";
			}
			ListaCurso = (List<TbAlumno>) session.createQuery(query).setParameter(":", "%" + prmCadena + "%")
					.getResultList();
			session.getTransaction().commit();
		} catch (HibernateException ex) {
			mess = ex.getMessage();
			session.getTransaction().rollback();
			ex.printStackTrace();
		}
		return ListaCurso;
	}
}
