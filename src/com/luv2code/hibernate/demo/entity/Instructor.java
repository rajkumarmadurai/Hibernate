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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstname;
	
	@Column(name="last_name")
	private String lastname;
	
	
	@Column(name="email")
	private String email;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="instructor",cascade= {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
   private List<Course> CourseList;
	
	

	public List<Course> getCourseList() {
		return CourseList;
	}


	public void setCourseList(List<Course> courseList) {
		CourseList = courseList;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetail instructorDetail;
    
    
    private Instructor() {
    	
    }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}


	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}


	public Instructor(String firstname, String lastname,String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	
	}


	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}
	
	
	public void add(Course tempCourse) {
		if(CourseList==null) {
			CourseList=new ArrayList<Course>();
		}
		CourseList.add(tempCourse);
		tempCourse.setInstructor(this);
	}
}
