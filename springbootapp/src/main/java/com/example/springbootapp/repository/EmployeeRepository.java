package com.example.springbootapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.example.springbootapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<Employee> findByFirstName(String firstName);

	Optional<Employee> findByContact(long contact);

	List<Employee> findByAge(byte age);
	
//	  @Modifying
//	    @Query("DELETE FROM Employee e WHERE e.someProperty = :someValue")
//	    void deleteBySomeProperty(@Param("someValue") String someValue);

}
