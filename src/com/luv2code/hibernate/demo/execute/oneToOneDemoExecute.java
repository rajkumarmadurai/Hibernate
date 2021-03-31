package com.luv2code.hibernate.demo.execute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class oneToOneDemoExecute {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
	
		session.beginTransaction();
		
	
		
		int id=session.createQuery("update Student set email='test@gmail.com'").executeUpdate();
		
		session.getTransaction().commit();
		
		
	//	System.out.println(list);
		
		System.out.println("Done");
		


	}

}
