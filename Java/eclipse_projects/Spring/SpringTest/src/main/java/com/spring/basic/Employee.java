package com.spring.basic;

public class Employee {

	private String empId;
	private String empName;
	private int exp;
	
	
	
	public Employee(String empId, String empName, int exp) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.exp = exp;
	}
	public Employee() {
		super();
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	
}
