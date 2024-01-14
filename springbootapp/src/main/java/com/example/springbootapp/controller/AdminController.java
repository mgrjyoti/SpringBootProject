package com.example.springbootapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootapp.entity.Admin;
import com.example.springbootapp.responce.AdminResponce;
import com.example.springbootapp.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping(path="/admin")
	public ResponseEntity<AdminResponce> addAsdmin(@RequestBody Admin admin) {
	Admin admin2=adminService.addAdmin(admin);
	if (admin2 != null) {
		AdminResponce adminResponce= new AdminResponce();
		adminResponce.setMessage("Admin Account Created Sucessfully.");
		adminResponce.setStatus(HttpStatus.CREATED.value());
		adminResponce.setAdmin(admin2);
		adminResponce.setAdmins(null);
		return new ResponseEntity<AdminResponce>(adminResponce, HttpStatus.CREATED);
		}
	else {
		AdminResponce adminResponce= new AdminResponce();
		adminResponce.setMessage("Admin Account Created Sucessfully.");
		adminResponce.setStatus(HttpStatus.CREATED.value());
		adminResponce.setAdmin(admin2);
		adminResponce.setAdmins(null);
		return new ResponseEntity<AdminResponce>(adminResponce, HttpStatus.CREATED);
	}	
	}
	
	@GetMapping(path="/admins")
	public ResponseEntity<AdminResponce> findAllAdmin() {
		List<Admin> admins= adminService.findAllAdmin();
		if (admins != null) {
			AdminResponce adminResponce= new AdminResponce();
			adminResponce.setMessage("Admin Accounts Found Sucessfully.");
			adminResponce.setStatus(HttpStatus.FOUND.value());
			adminResponce.setAdmin(null);
			adminResponce.setAdmins(admins);
			return new ResponseEntity<AdminResponce>(adminResponce, HttpStatus.FOUND);
			}
		else {
			AdminResponce adminResponce= new AdminResponce();
			adminResponce.setMessage("Admin Account not Found.");
			adminResponce.setStatus(HttpStatus.NOT_FOUND.value());
			adminResponce.setAdmin(null);
			adminResponce.setAdmins(admins);
			return new ResponseEntity<AdminResponce>(adminResponce, HttpStatus.NOT_FOUND);
		}	
	}
	
	@GetMapping(path = "/admin/{id}")
	public ResponseEntity<AdminResponce> findAdminById(@PathVariable int id) {
		
		Admin admin = adminService.findAdminById(id);
		if (admin != null) {
			AdminResponce adminResponce= new AdminResponce();
			adminResponce.setMessage("Admin Account Found Sucessfully.");
			adminResponce.setStatus(HttpStatus.FOUND.value());
			adminResponce.setAdmin(admin);
			adminResponce.setAdmins(null);
			return new ResponseEntity<AdminResponce>(adminResponce, HttpStatus.FOUND);	
		}
		else {
			AdminResponce adminResponce= new AdminResponce();
			adminResponce.setMessage("Admin Account not Found.");
			adminResponce.setStatus(HttpStatus.NOT_FOUND.value());
			adminResponce.setAdmin(null);
			adminResponce.setAdmins(null);
			return new ResponseEntity<AdminResponce>(adminResponce, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path="/login/{name}/{password}")
	public ResponseEntity<AdminResponce> findByNameAndPassword(@PathVariable String name,@PathVariable String password) {
		
		Admin admin = adminService.findByNameAndPassword(name, password);
		
		if (admin != null && (name.equals(admin.getName()) && password.equals(admin.getPassword()))) {
			AdminResponce adminResponce= new AdminResponce();
			adminResponce.setMessage("Admin Account Found Sucessfully.");
			adminResponce.setStatus(HttpStatus.FOUND.value());
			adminResponce.setAdmin(null);
			adminResponce.setAdmins(null);
			return new ResponseEntity<AdminResponce>(adminResponce, HttpStatus.FOUND);	
		}
		else {
			AdminResponce adminResponce= new AdminResponce();
			adminResponce.setMessage("Admin Account not Found.");
			adminResponce.setStatus(HttpStatus.NOT_FOUND.value());
			adminResponce.setAdmin(null);
			adminResponce.setAdmins(null);
			return new ResponseEntity<AdminResponce>(adminResponce, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path="/admin/{id}")
	public ResponseEntity<AdminResponce> deleteAdminById(@PathVariable int id){
		Admin admin =adminService.deleteAdminById(id);
		AdminResponce adminResponce=new AdminResponce();
		adminResponce.setMessage("Admin deleted Sucessfully...");
		adminResponce.setStatus(HttpStatus.OK.value());
		adminResponce.setAdmin(admin);
		return new ResponseEntity<AdminResponce>(adminResponce,HttpStatus.OK);
		
	}
	
	@PutMapping(path="/admin")
	public ResponseEntity<AdminResponce> updateAdmin(@RequestBody Admin admin){
		Admin admin2 =adminService.updateAdmin(admin);
		AdminResponce adminResponce= new AdminResponce();
		adminResponce.setMessage("Admin updated sucessfully....");
		adminResponce.setStatus(HttpStatus.OK.value());
		adminResponce.setAdmin(admin2);
		return new ResponseEntity<AdminResponce>(adminResponce,HttpStatus.OK);
		
	}
}

























