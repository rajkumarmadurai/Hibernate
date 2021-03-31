package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			//Create a student object
			Student tempStuud=new Student("Rajkumar","ma","rajkumar@gmail.com");
			//start the transaction 
			session.beginTransaction();
			//save the transaction
			session.save(tempStuud);			
			//commit 
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
