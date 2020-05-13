package com.insidethesandbox.employeeservice.service;

import com.insidethesandbox.employeeservice.model.employee.Employee;
import com.insidethesandbox.employeeservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

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
                "query", Collections.singletonList(employeeRepository.findById(id).orElse(null))));
    }

    // Query all employees
    public Employee.Wrapper getAllEmployees() {
        return new Employee.Wrapper(Collections.singletonMap("query", employeeRepository.findAll()));
    }

    // Update employee by object
    public Employee.Wrapper updateEmployeeByObject(Employee employee) {
        return new Employee.Wrapper(Collections.singletonMap(
                "created", Collections.singletonList(employeeRepository.save(employee))
        ));
    }

    // Delete employee by ID
    public Employee.Wrapper deleteEmployeeById(final String id) {

        Employee employee = employeeRepository.findById(id).orElse(null);

        employeeRepository.deleteById(id);
        return new Employee.Wrapper(Collections.singletonMap(
                "deleted", Collections.singletonList(employee)));
    }
}
