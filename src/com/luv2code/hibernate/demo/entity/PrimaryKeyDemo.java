package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			//Create a student object
			Student tempStuud=new Student("Sathya","Murges","sathya@gmail.com");
			Student tempStuud1=new Student("Advik","Raj","advik@gmail.com");
			Student tempStuud2=new Student("Devaki","Rama","devkumar@gmail.com");
			//start the transaction 
			session.beginTransaction();
			//save the transaction
			session.save(tempStuud);	
			session.save(tempStuud1);	
			session.save(tempStuud2);	
			//commit 
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
