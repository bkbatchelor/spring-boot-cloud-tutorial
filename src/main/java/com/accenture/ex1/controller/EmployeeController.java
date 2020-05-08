package com.accenture.ex1.controller;


import com.accenture.ex1.model.Employee;
import com.accenture.ex1.model.EmployeeWrapper;
import com.accenture.ex1.service.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Create employee
    @PostMapping("/employee")
    public EmployeeWrapper createEmployee(@Valid @RequestBody Employee employee) {
        return new EmployeeWrapper(employeeRepository.save(employee));
    }

    //Read all employees
    @GetMapping("/employees")
    public EmployeeWrapper getEmployees() {
        return new EmployeeWrapper(employeeRepository.findAll());
    }

    //Read employee
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(new Employee(id));
    }

    //Update employee
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateRecord(@PathVariable(value = "id") String id) {
        return new ResponseEntity<>(new Employee(id), HttpStatus.ACCEPTED);
    }

    //Delete employee
    @DeleteMapping("/employee/{id}")
    public Map<String,String> deleteEmployee(@PathVariable(value = "id") String id) {
        Map<String, String> map = new HashMap<>();
        map.put("delete", "successful");
        return map;
    }
}
