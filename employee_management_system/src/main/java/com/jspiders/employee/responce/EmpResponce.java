package com.jspiders.employee.responce;

import java.util.List;

import com.jspiders.employee.entity.Employee;

import lombok.Data;
@Data
public class EmpResponce {

	private String message;
	private int status;
	private Employee employee;
	private List<Employee> employees;
}
