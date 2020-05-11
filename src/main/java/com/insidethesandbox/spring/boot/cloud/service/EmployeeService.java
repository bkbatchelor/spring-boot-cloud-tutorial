package com.insidethesandbox.spring.boot.cloud.service;

import com.insidethesandbox.spring.boot.cloud.model.employee.Employee;
import com.insidethesandbox.spring.boot.cloud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }


    // Create employee
    public Employee.Wrapper createEmployee(Employee employee ){
        return new Employee.Wrapper(Collections.singletonMap(
                "created", Collections.singletonList(employeeRepository.save(employee))
        ));
    }

    // Query employee by ID
    public Employee.Wrapper getEmployeeById(String id) {
        return new Employee.Wrapper(Collections.singletonMap(
                "query", Collections.singletonList(employeeRepository.findById(id).get())));
    }

    // Query employee by object
    public Employee.Wrapper getAllEmployees() {
        return new Employee.Wrapper(Collections.singletonMap("query", employeeRepository.findAll()));
    }

    // Query all employees

    // Update employee by ID

    // Update  employee by ID

    // Update employee by object

    // Delete employee by ID

    // Delete employee by object

    // Delete all employees
}
