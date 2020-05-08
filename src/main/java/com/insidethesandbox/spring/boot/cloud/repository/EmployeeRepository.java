package com.insidethesandbox.spring.boot.cloud.repository;

import com.insidethesandbox.spring.boot.cloud.model.employee.EmployeeModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<EmployeeModel, String> {
}
