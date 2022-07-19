package com.ovaldez.keycloak.comtroller;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ovaldez.keycloak.entity.Employee;
import com.ovaldez.keycloak.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	@RolesAllowed("admin")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
		return ResponseEntity.ok(employeeService.save(employee));
	}
	
	@GetMapping
	@RolesAllowed("admin")
	public ResponseEntity<?> findAllEmployees(){
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@GetMapping("/{id}")
	@RolesAllowed("user")
	public ResponseEntity<?> getEmployeeById(@PathVariable final String id){
		return ResponseEntity.ok(employeeService.findById(id));
	}
}
