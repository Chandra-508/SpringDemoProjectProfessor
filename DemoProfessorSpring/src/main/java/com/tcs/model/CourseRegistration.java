package com.tcs.model;

public class CourseRegistration {
	
   public CourseRegistration(int courseId, int studentId, int professorId) {
		super();
		this.courseId = courseId;
		this.studentId = studentId;
		ProfessorId = professorId;
	}
private int courseId;
   private int studentId;
   private int ProfessorId;
   
   
   public int getCourseId() {
	return courseId;
}
public void setCourseId(int courseId) {
	this.courseId = courseId;
}
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public int getProfessorId() {
	return ProfessorId;
}
public void setProfessorId(int professorId) {
	ProfessorId = professorId;
}
}
   
  