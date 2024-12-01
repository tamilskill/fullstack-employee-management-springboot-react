package com.tamilskillhub.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamilskillhub.employee.model.Employee;
import com.tamilskillhub.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repo;
	
	public List<Employee> findAllEmployees(){
		return repo.findAll();
	}
	
	public Employee findEmployeeById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public String addEmployee(Employee employee) {
		repo.save(employee);
		return "Employee Saved successfully";
	}
	
	public String updateEmployee(Employee employee) {
		repo.save(employee);
		return "Employee updated successfully";
	}
	
	public String deleteEmployee(Long id) {
		repo.deleteById(id);
		return "Employee deleted Successfully";
	}
}
