/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rafael.hibernet.Modelo;
	
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Anibal
 */
public class HibernateUtil 
{

    static Session session;
    
    //opcion 01
    static public  Session getSession() 
    {
    	
    	SessionFactory sessionFactory=null;
    	
    	if (session == null) 
        {
        	Configuration configuration = new Configuration();
        	configuration.configure(); 
        	sessionFactory = configuration.buildSessionFactory();

        	session = sessionFactory.openSession();
        }
    	
        if(!session.getTransaction().isActive()) {
            session.beginTransaction();
        }
        return session;
    }
}
