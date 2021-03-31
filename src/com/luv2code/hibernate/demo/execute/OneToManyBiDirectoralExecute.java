package com.luv2code.hibernate.demo.execute;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class OneToManyBiDirectoralExecute {

	public static void main(String[] args) {
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
	
		session.beginTransaction();
		
		Instructor instructor=new Instructor("Advik","Alagar","advikalagar.ma@gmail.com");
		
		Course cousreList=new Course("Air Guitar");
		Course cousreList2=new Course("Air france");
		instructor.add(cousreList);
		instructor.add(cousreList2);
		
		InstructorDetail instructorDetail=new InstructorDetail("youTube.com","Movies",instructor);
		
		instructorDetail.setInstructor(instructor);
		
		
		
		session.save(cousreList);
		session.save(cousreList2);
		
		//List<Student> list=session.createQuery("from Student").list();
		
		session.save(instructorDetail);
		
		session.getTransaction().commit();
		
		
	//	System.out.println(list);
		
		System.out.println("Done");
		

	}

}
