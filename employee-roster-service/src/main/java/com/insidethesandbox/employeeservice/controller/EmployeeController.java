package com.insidethesandbox.employeeservice.controller;


import com.insidethesandbox.employeeservice.model.employee.Employee;
import com.insidethesandbox.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee-service")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Create employee
    @PostMapping("/employee")
    public Employee.Wrapper createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    //Read all employees
    @GetMapping("/employees")
    public Employee.Wrapper getEmployees() {
        return employeeService.getAllEmployees();
    }

    //Read employee
    @GetMapping("/employee/{id}")
    public Employee.Wrapper getEmployee(@PathVariable(value = "id") String id) {
        return employeeService.getEmployeeById(id);
    }

    //Update employee
    @PutMapping("/employee")
    public Employee.Wrapper updateRecord(@Valid @RequestBody Employee employee) {
        return employeeService.updateEmployeeByObject(employee);
    }

    //Delete employee
    @DeleteMapping("/employee/{id}")
    public Employee.Wrapper deleteEmployee(@PathVariable(value = "id") String id) {
        return employeeService.deleteEmployeeById(id);
    }
}
