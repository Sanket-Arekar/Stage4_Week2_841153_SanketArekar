package com.cognizant.employeeservice.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employeeservice.models.Employee;
import com.cognizant.employeeservice.service.EmployeeServiceImpl;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployees(){
		return employeeServiceImpl.getAllEmployees();
	}
	
	
	@GetMapping(value ="/{emp_id}",produces = MediaType.APPLICATION_JSON)
	public Employee getEmployeeById(@PathVariable @Valid int emp_id) {
		// TODO Auto-generated method stub
		return employeeServiceImpl.getEmployeeById(emp_id);
	}

	@PutMapping(value ="/{emp_id}", produces = MediaType.APPLICATION_JSON)
	public Employee updateEmployeeDetails(@PathVariable @Valid int emp_id,@RequestBody Employee employee) {
		// TODO Auto-generated method stub
		return employeeServiceImpl.updateEmployeeDetails(emp_id, employee);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON)
	public Employee addEmployee(@RequestBody Employee employee) {
		// TODO Auto-generated method stub
		return employeeServiceImpl.addEmployee(employee);
	}

	@DeleteMapping(value= "/{emp_id}")
	public String deleteEmployee(@PathVariable @Valid int emp_id) {
		// TODO Auto-generated method stub
		employeeServiceImpl.deleteEmployee(emp_id);
		return "Employee Deleted Successfully";
	}
}
