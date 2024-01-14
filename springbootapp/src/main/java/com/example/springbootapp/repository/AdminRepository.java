package com.example.springbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootapp.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Admin findByNameAndPassword(String name, String password);

}
