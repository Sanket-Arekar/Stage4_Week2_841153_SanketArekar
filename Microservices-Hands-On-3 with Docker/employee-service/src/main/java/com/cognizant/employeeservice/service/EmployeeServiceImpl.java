package com.cognizant.employeeservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeeservice.dao.EmployeeDaoImpl;
import com.cognizant.employeeservice.models.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDaoImpl employeeDaoImpl;

	@Override
	public Employee getEmployeeById(int emp_id) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.getEmployeeById(emp_id);
	}

	@Override
	public Employee updateEmployeeDetails(int emp_id, Employee employee) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.updateEmployeeDetails(emp_id, employee);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.addEmployee(employee);
	}

	@Override
	public void deleteEmployee(int emp_id) {
		// TODO Auto-generated method stub
		employeeDaoImpl.deleteEmployee(emp_id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDaoImpl.getAllEmployees();
	}
}
