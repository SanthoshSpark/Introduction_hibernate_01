package com.hibernate.demo;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;		
		
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			Product p1 = new Product("Pen",10,120);
			
			session.save(p1);

			
		}catch(HibernateException e){
			
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
			
		}catch(Exception e) {

			if(tx != null)
				tx.rollback();
			e.printStackTrace();
			
		}finally {
			
			if(tx != null)
				tx.commit();
			if(sessionFactory != null)
				sessionFactory.close();
		}

	}

}
