package com.tamilskillhub.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tamilskillhub.employee.model.Employee;
import com.tamilskillhub.employee.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/welcome")
	public String welcome() {
		return "Hello Subscribers!";
	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.findAllEmployees();
	}

	@GetMapping("/employee/{id}")
	public Employee findEmployeeById(@PathVariable Long id) {
		return employeeService.findEmployeeById(id);
	}

	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		return "Employee Saved successfully";
	}

	@PutMapping("/employee/{id}")
	public String updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		
		Employee existingEmployee = employeeService.findEmployeeById(id);
		
		if(existingEmployee != null) {
			if(employee.getName() != null)
				existingEmployee.setName(employee.getName());
			if(employee.getDepartment() != null)
				existingEmployee.setDepartment(employee.getDepartment());
			
			return employeeService.updateEmployee(existingEmployee);
		}
		
		return "Unable to find employee";
	}

	@DeleteMapping("employee/{id}")
	public String deleteEmployee(@PathVariable Long id) {

		return employeeService.deleteEmployee(id);
	}
}
