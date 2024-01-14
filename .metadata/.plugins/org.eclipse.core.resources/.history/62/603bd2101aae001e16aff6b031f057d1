package com.jspiders.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false,unique = true)
	private String email;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false,unique = true)
	private long contact;
	@Column(nullable = false)
	private double salary;
	@Column(nullable = false)
	private byte age;
	
}
