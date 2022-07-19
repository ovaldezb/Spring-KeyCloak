package com.ovaldez.keycloak.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovaldez.keycloak.entity.Employee;
import com.ovaldez.keycloak.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public Employee save(Employee employe) {
		return employeeRepository.save(employe);
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> findById(String id){
		return employeeRepository.findById(id);
	}
	
	public String deleteById(String id) {
		employeeRepository.deleteById(id);
		return "Suceess";
	}
}


