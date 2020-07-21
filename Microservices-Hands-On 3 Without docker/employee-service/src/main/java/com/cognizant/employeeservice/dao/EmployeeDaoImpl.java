package com.cognizant.employeeservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeeservice.exception.EmployeeNotFoundException;
import com.cognizant.employeeservice.models.Employee;
import com.cognizant.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee getEmployeeById(int emp_id) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(emp_id).orElseThrow(() -> {throw new EmployeeNotFoundException();});
		return employee;
	}

	@Override
	public Employee updateEmployeeDetails(int emp_id, Employee employee) {
		// TODO Auto-generated method stub
		Employee employeeFound = employeeRepository.findById(emp_id).orElseThrow(() -> {throw new EmployeeNotFoundException();});

		employeeFound.setName(employee.getName());
		employeeFound.setPermanent(employee.isPermanent());
		employeeFound.setDateOfBirth(employee.getDateOfBirth());
		employeeFound.setSalary(employee.getSalary());
		employeeRepository.save(employeeFound);
		return employeeFound;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Employee emplyeeAdded = employeeRepository.save(employee);

		return emplyeeAdded;
	}

	@Override
	public void deleteEmployee(int emp_id) {
		// TODO Auto-generated method stub

		Employee employeeFound = employeeRepository.findById(emp_id).orElseThrow(() -> {throw new EmployeeNotFoundException();});
		employeeRepository.delete(employeeFound);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> listOfEmployees = employeeRepository.findAll();

		return listOfEmployees;
	}

}
