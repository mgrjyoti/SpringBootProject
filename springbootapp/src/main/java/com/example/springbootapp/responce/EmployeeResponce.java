package com.example.springbootapp.responce;

import java.util.List;

import com.example.springbootapp.entity.Employee;

import lombok.Data;

@Data
public class EmployeeResponce {

	private String message;
	private int status;
	private Employee employee;
	private List<Employee> employees;
		
}

