package com.spring.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.basic.Employee;
import com.spring.rest.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/employee")
	public List<Employee> getEmployees() {
		List<Employee> empList = null;
		empList = employeeService.getEmployees();
		return empList;
	}

	@RequestMapping("/employee/updateExp/{exp}")
	public List<Employee> UpdateEmployeesExperience(@PathVariable("exp") int exp) {
		List<Employee> empList = null;
		empList = employeeService.getEmployees();
		for (Employee e : empList) {
			e.setExp(e.getExp() + exp);
		}
		return empList;
	}

	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public @ResponseBody List<Employee> addEmployee(@RequestBody Employee e) {
		List<Employee> empList = null;
		empList = employeeService.getEmployees();
		empList.add(e);
		return empList;
	}

	@RequestMapping(value = "/employee/remove/{id}", method = RequestMethod.POST)
	public @ResponseBody List<Employee> removeEmployee(@PathVariable("id") String id) {
		List<Employee> empList = null;
		empList = employeeService.getEmployees();
		for (Employee e : empList) {
			if(e.getEmpId().equals(id)){
				empList.remove(e);
			}
		}
		return empList;
	}

}
