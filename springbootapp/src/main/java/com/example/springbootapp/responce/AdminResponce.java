package com.example.springbootapp.responce;

import java.util.List;

import com.example.springbootapp.entity.Admin;

import lombok.Data;
@Data
public class AdminResponce {

	private String message;
	private int status;
	private Admin admin;
	private List<Admin> admins;
	
}