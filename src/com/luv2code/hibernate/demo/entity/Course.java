package com.luv2code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="title")
   private String title;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="instructor_id")
   private Instructor instructor;	
   
   
   public Course() {
	   
   }


@Override
public String toString() {
	return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public Instructor getInstructor() {
	return instructor;
}


public void setInstructor(Instructor instructor) {
	this.instructor = instructor;
}

@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
@JoinColumn(name="course_id")
private List<Review> reviews;



public List<Review> getReviews() {
	return reviews;
}


public void setReviews(List<Review> reviews) {
	this.reviews = reviews;
}


public Course(String title) {
	super();
	this.title = title;
}


public void addReview(Review review) {
	if(reviews==null) {
		reviews=new ArrayList<Review>();
	}
	reviews.add(review);
}

@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
@JoinTable(name="course_student",
            joinColumns=@JoinColumn(name="course_id"),
            inverseJoinColumns=@JoinColumn(name="student_id"))
List<Student> studentList;


public List<Student> getStudentList() {
	return studentList;
}


public void setStudentList(List<Student> studentList) {
	this.studentList = studentList;
}

}
