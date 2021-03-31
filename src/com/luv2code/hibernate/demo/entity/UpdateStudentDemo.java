package com.luv2code.hibernate.demo.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
	
		session.beginTransaction();
		
		Instructor instructor=new Instructor("rajkumar","MA","rajkumar.ma@gmail.com");
		
		InstructorDetail instructorDetail=new InstructorDetail("youTube.com","Movies",instructor);
		
		instructor.setInstructorDetail(instructorDetail);
		
		//List<Student> list=session.createQuery("from Student").list();
		
		session.save(instructor);
		
		session.getTransaction().commit();
		
		
	//	System.out.println(list);
		
		System.out.println("Done");
		

	}

}
