package com.ovaldez.keycloak.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ovaldez.keycloak.entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
