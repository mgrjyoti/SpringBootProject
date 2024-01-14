package com.jspiders.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.employee.entity.Employee;
import com.jspiders.employee.responce.EmpResponce;
import com.jspiders.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(path = "/employee")
	public ResponseEntity<EmpResponce> addEmployee(@RequestBody Employee employee) {
	Employee employee1 = employeeService.addEmployee(employee);
		EmpResponce empResponce=new EmpResponce();
			empResponce.setMessage("Employee Added Sucessfully....");
			empResponce.setStatus(HttpStatus.CREATED.value());
			empResponce.setEmployee(employee1);
			empResponce.setEmployees(null);
		return new ResponseEntity<EmpResponce>(empResponce,HttpStatus.CREATED);
	}
	
	@GetMapping(path="/employees")
	public ResponseEntity<EmpResponce> getAllEmployee() {
		List<Employee> employees=employeeService.getAllEmployee();
		if (employees != null && employees.size() > 0) {
			EmpResponce empResponce=new EmpResponce();
			empResponce.setMessage("Employees fetched Sucessfully....");
			empResponce.setStatus(HttpStatus.FOUND.value());
			empResponce.setEmployee(null);
			empResponce.setEmployees(employees);
			return new ResponseEntity<EmpResponce>(empResponce,HttpStatus.FOUND);	
		}
		else {
			EmpResponce empResponce=new EmpResponce();
			empResponce.setMessage("Employees not fetched ");
			empResponce.setStatus(HttpStatus.NOT_FOUND.value());
			empResponce.setEmployee(null);
			empResponce.setEmployees(null);
			return new ResponseEntity<EmpResponce>(empResponce,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(path="/employee/{Id}")
	public ResponseEntity<EmpResponce> findEmployeeById(@RequestParam long id) {
		Employee employee = employeeService.findEmployeeById(id);
		if (employee != null) {
			EmpResponce empResponce=new EmpResponce();
			empResponce.setMessage("Employee fetched Sucessfully....");
			empResponce.setStatus(HttpStatus.FOUND.value());
			empResponce.setEmployee(employee);
			empResponce.setEmployees(null);
			return new ResponseEntity<EmpResponce>(empResponce,HttpStatus.FOUND);
		}
		else {
			EmpResponce empResponce=new EmpResponce();
			empResponce.setMessage("Employee not Fount ");
			empResponce.setStatus(HttpStatus.NOT_FOUND.value());
			empResponce.setEmployee(null);
			empResponce.setEmployees(null);
			return new ResponseEntity<EmpResponce>(empResponce,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<EmpResponce> deleteEmployeeById(@RequestParam  long id) {
		Employee employee = employeeService.deleteEmployeeById(id);
		if (employee != null) {
			EmpResponce empResponce= new EmpResponce();
			empResponce.setMessage("Employee deleted Sucessfully...");
			empResponce.setStatus(HttpStatus.OK.value());
			empResponce.setEmployees(null);
			empResponce.setEmployees(null);
			return new ResponseEntity<EmpResponce>(empResponce,HttpStatus.OK);
		}
		else {
			EmpResponce empResponce=new EmpResponce();
			empResponce.setMessage("Employee not Fount ");
			empResponce.setStatus(HttpStatus.NOT_FOUND.value());
			empResponce.setEmployee(null);
			empResponce.setEmployees(null);
			return new ResponseEntity<EmpResponce>(empResponce,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path="/getname")
	public ResponseEntity<EmpResponce> getEmployeeByName(@RequestParam String firstName) {
		Employee employee=employeeService.getEmployeeByName(firstName);
		if (employee != null) {
			EmpResponce empResponce=new EmpResponce();
			empResponce.setMessage("Employee fetched sucessfully....");
			empResponce.setStatus(HttpStatus.FOUND.value());
			empResponce.setEmployee(employee);
			empResponce.setEmployees(null);
			return new ResponseEntity<EmpResponce>(empResponce,HttpStatus.FOUND);
		}
		else {
			EmpResponce empResponce=new EmpResponce();
			empResponce.setMessage("Employee not Fount ");
			empResponce.setStatus(HttpStatus.NOT_FOUND.value());
			empResponce.setEmployee(null);
			empResponce.setEmployees(null);
			return new ResponseEntity<EmpResponce>(empResponce,HttpStatus.NOT_FOUND);
		}
	
		
		
	}
}
