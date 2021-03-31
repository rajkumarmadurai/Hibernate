package com.luv2code.hibernate.demo.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadstudentDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			//Create a student object
			Student tempStuud=new Student("Ashok","ma","Ashok@gmail.com");
			/*//start the transaction 
			session.beginTransaction();
			//save the transaction
			session.save(tempStuud);			
			//commit 
			session.getTransaction().commit();
			*/
			
				
			session.beginTransaction();
			
			//List<Student> list=session.createQuery("from Student").list();
			
			List<Student> list=session.createQuery("from Student from firstname='Rajkumar'").getResultList();
			
			session.getTransaction().commit();
			
			
			System.out.println(list);
			
			System.out.println("Done");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
