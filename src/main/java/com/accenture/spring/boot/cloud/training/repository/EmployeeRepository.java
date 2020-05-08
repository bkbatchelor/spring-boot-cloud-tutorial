package com.accenture.spring.boot.cloud.training.repository;

import com.accenture.spring.boot.cloud.training.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
