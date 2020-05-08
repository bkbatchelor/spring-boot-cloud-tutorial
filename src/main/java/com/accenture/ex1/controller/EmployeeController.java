package com.accenture.ex1.controller;


import com.accenture.ex1.model.Employee;
import com.accenture.ex1.model.EmployeeWrapper;
import com.accenture.ex1.service.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public EmployeeWrapper getEmployee(@PathVariable(value = "id") String id) {
        return new EmployeeWrapper(employeeRepository.findById(id).get());
    }

    //Update employee
    @PutMapping("/employee/")
    public EmployeeWrapper updateRecord(@Valid @RequestBody Employee employee) {
        return new EmployeeWrapper((employeeRepository.save(employee)));
    }

    //Delete employee
    @DeleteMapping("/employee/{id}")
    public Map<String,String> deleteEmployee(@PathVariable(value = "id") String id) {
        Map<String, String> map = new HashMap<>();
        map.put("delete", "successful");
        return map;
    }
}
