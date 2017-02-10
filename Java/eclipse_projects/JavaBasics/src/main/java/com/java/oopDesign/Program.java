package com.java.oopDesign;

import java.util.ArrayList;
import java.util.List;

public class Program {

	int programId;
	String programName;	
	List<Student> students = new ArrayList<Student>();
	
	
	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Program(int programId, String programName) {
		super();
		this.programId = programId;
		this.programName = programName;
	}

	public int getNumOfStudentsAllocated(){
		return students.size();
	}
	
}
