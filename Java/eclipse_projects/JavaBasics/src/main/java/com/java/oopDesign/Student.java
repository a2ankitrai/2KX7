package com.java.oopDesign;


public class Student {

	private String id;
	private String name;
	private String country;
	private Program program;
	private double[] grades = new double[3];
 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public double[] getGrades() {
		return grades;
	}

	public void setGrades(double[] grades) {
		this.grades = grades;
	}
	 
	public double GPA() {
		double gradeSum = 0.0;
		for (double grade : grades) {
			gradeSum += grade;
		}
		return gradeSum / grades.length;
	}

	public boolean canSubmitToCoopActivity() {
		return GPA() >= 2.8;
	}

}
