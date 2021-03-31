package com.luv2code.hibernate.demo.execute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class OneToOneBiDirectoralExecute {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
	
		session.beginTransaction();
		
		Instructor instructor=new Instructor("sathiya","murugesan","sathiya.ma@gmail.com");
		
		InstructorDetail instructorDetail=new InstructorDetail("youTube.com","Movies",instructor);
		
		instructorDetail.setInstructor(instructor);
		
		//List<Student> list=session.createQuery("from Student").list();
		
		session.save(instructorDetail);
		
		session.getTransaction().commit();
		
		
	//	System.out.println(list);
		
		System.out.println("Done");
		

	}

}
