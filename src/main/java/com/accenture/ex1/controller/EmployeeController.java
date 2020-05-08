package com.accenture.ex1.controller;


import com.accenture.ex1.model.Employee;
import com.accenture.ex1.model.EmployeeWrapper;
import com.accenture.ex1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
        return new EmployeeWrapper(employeeRepository.save(employee));
    }

    //Delete employee
    @DeleteMapping("/employee/{id}")
    public EmployeeWrapper deleteEmployee(@PathVariable(value = "id") String id) {
        employeeRepository.deleteById(id);

        Map<String, List<String>> status = new HashMap<>();
        status.put("deleted", Collections.singletonList(id));
        return new EmployeeWrapper(status);
    }
}
