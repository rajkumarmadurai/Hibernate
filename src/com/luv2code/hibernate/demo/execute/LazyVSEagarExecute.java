package com.luv2code.hibernate.demo.execute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class LazyVSEagarExecute {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
	
		session.beginTransaction();
		int id=1;
		
		Query<Instructor> query=session.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:theInstructorId",Instructor.class);
		
		//Instructor instructor=session.get(Instructor.class,id);

		query.setParameter("theInstructorId", id);
		
		Instructor instructor=query.getSingleResult();
		System.out.println(instructor);
		
		session.getTransaction().commit();
		
		
	//	System.out.println(list);
		
		System.out.println("Done");
		

	}

}
