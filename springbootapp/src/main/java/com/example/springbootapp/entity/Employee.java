package com.example.springbootapp.entity;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private long contact;
	@Column(nullable = false)
	private String address;
	private byte age;
	@Column(nullable = false)
	private String dob;
	@Column(nullable = false)
	private String doj;
	@Column(nullable = false)
	private double salary;
	//	public String getSomeProperty() {
//		return null;
//	}
	
	
	
}












