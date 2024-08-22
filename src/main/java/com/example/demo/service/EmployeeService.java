package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeerepo;
	
	public Employee updateEmployee(Employee employee) {
		return employeerepo.save(employee);
		// TODO Auto-generated method stub
		
	}

	public Employee saveEmployee(Employee employee){
	return employeerepo.save(employee);
	
	
		
	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeerepo.findAll();
	}

	

	public void deleteEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		employeerepo.deleteById(id);
	}

	public Employee getEmployeeById(Integer id){
		return employeerepo.findById(id).get();
	}

}
