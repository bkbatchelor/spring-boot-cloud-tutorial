package com.insidethesandbox.employeeservice.repository;

import com.insidethesandbox.employeeservice.model.employee.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
