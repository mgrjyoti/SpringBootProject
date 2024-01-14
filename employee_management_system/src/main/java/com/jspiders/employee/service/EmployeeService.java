package com.jspiders.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.employee.entity.Employee;
import com.jspiders.employee.repository.EmployeeRepository;



@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployee() {
		
		return employeeRepository.findAll();
	}

	public Employee getEmployeeByName(String firstName) {
		return null;
	}

	public Employee findEmployeeById(long id) {
Optional<Employee> emOptional=employeeRepository.findById(id);
if (emOptional.isPresent()) {
	return emOptional.get();
}else {
	return null;
}
	}
	
	public Employee deleteEmployeeById(long id) {
	Employee employee= findEmployeeById(id);
	employeeRepository.deleteById(id);
		return employee;
	}
	
}
