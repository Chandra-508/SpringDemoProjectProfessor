/**
 * 
 */
package com.tcs.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.model.*;
import com.tcs.constant.*;

/**
 * @author Administrator
 *
 */

@RestController
public class ProfessorController {
	
private static final Logger logger = LoggerFactory.getLogger(ProfessorController.class);
	
	//Map to store employees, ideally we should use database
	Map<Integer, Grade> gradeList = new HashMap<Integer, Grade>();
	Map<Integer, CourseRegistration> studentList = new HashMap<Integer, CourseRegistration>();
	
	public void putMethod() {
		 studentList.put(101, new CourseRegistration(1101,201,502));
		 studentList.put(102, new CourseRegistration(1102,201,502));
		 studentList.put(103, new CourseRegistration(1103,202,502));
		 studentList.put(104, new CourseRegistration(1104,202,502));
		 
	}
	@RequestMapping(value = ProfessorRestURIConstants.VIEW_STUDENTS, method = RequestMethod.GET)
	public @ResponseBody List<CourseRegistration> getEnrolledStudents() {
		putMethod();
		logger.info("List of Students");
		List<CourseRegistration> student = new ArrayList<CourseRegistration>();
		Set<Integer> studentIds = studentList.keySet();
		for(Integer i : studentIds) {
			student.add(studentList.get(i));
		}
		return student;
	}
	
	@RequestMapping(value = ProfessorRestURIConstants.ADD_GRADES, method = RequestMethod.POST)
	public @ResponseBody Grade addGrades(@RequestBody Grade cr) {
		putMethod();
		logger.info("Adding of Grades to Students");
		Grade gc = new Grade();
		Set<Integer> studentIds = studentList.keySet();
		for(int i=0;i<studentIds.size();i++) {
			if(studentList.get(i).getStudentId()==cr.getStudentId() && studentList.get(i).getCourseId()==cr.getCourseId()) {
				gc.setStudentId(cr.getStudentId());
				gc.setCourseId(cr.getCourseId());
				gc.setGrade(cr.getGrade());
				gradeList.put(cr.getStudentId(), gc);
			}
		}
		return gc;
	}
}