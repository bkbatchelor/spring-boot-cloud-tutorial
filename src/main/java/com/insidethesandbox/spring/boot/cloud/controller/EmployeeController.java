package com.insidethesandbox.spring.boot.cloud.controller;


import com.insidethesandbox.spring.boot.cloud.model.employee.Employee;
import com.insidethesandbox.spring.boot.cloud.repository.EmployeeRepository;
import com.insidethesandbox.spring.boot.cloud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository,
                              EmployeeService employeeService){
        this.employeeRepository = employeeRepository;
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
        Map<String, List<Employee>> responseListMap = new HashMap<>();
        responseListMap.put("query", employeeRepository.findAll());

        return new Employee.Wrapper(responseListMap);
    }

    //Read employee
    @GetMapping("/employee/{id}")
    public Employee.Wrapper getEmployee(@PathVariable(value = "id") String id) {
        Map<String, List<Employee>> responseListMap = new HashMap<>();
        responseListMap.put("query", Collections.singletonList(employeeRepository.findById(id).get()));

        return new Employee.Wrapper(responseListMap);
    }

    //Update employee
    @PutMapping("/employee")
    public Employee.Wrapper updateRecord(@Valid @RequestBody Employee employee) {
        Map<String, List<Employee>> responseListMap = new HashMap<>();
        responseListMap.put("updated", Collections.singletonList(employeeRepository.save(employee)));

        return new Employee.Wrapper(responseListMap);
    }

    //Delete employee
    @DeleteMapping("/employee/{id}")
    public HttpStatus deleteEmployee(@PathVariable(value = "id") String id) {
        employeeRepository.deleteById(id);

        Map<String, List<Employee>> listMap = new HashMap<>();

        return HttpStatus.OK;
    }
}
