package com.spring.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.basic.Employee;

@Service
public class EmployeeService {

	public List<Employee> getEmployees(){
		
		List<Employee> list= new ArrayList<>();
		
		Employee e1 = new Employee("1","John Wick",2);
		Employee e2 = new Employee("2","Jade lober",6);
		Employee e3 = new Employee("3","Kurt Cobain",5);
		
		list.add(e1);list.add(e2);list.add(e3);
		
		return list;
	}
}
