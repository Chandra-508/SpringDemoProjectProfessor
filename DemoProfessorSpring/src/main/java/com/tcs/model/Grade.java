package com.tcs.model;

public class Grade {
	
	private int StudentId;
    /***public Grade(int studentId, int courseId, String grade) {
		super();
		StudentId = studentId;
		CourseId = courseId;
		this.grade = grade;
	}****/
	
	private int CourseId;
    private String grade;
    
    
    
    
     public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
     
     
}
