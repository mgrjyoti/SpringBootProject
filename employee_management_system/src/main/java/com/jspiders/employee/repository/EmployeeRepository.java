package com.jspiders.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
}