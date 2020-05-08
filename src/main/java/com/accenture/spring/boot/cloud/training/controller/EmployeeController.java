package com.accenture.spring.boot.cloud.training.controller;


import com.accenture.spring.boot.cloud.training.model.Employee;
import com.accenture.spring.boot.cloud.training.model.EmployeeWrapper;
import com.accenture.spring.boot.cloud.training.repository.EmployeeRepository;
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

    @Autowired
    private EmployeeRepository employeeRepository;

    //Create employee
    @PostMapping("/employee")
    public EmployeeWrapper createEmployee(@Valid @RequestBody Employee employee) {
        Map<String, List<Employee>> responseListMap = new HashMap<>();
        responseListMap.put("created", Collections.singletonList(employeeRepository.save(employee)));

        return new EmployeeWrapper(responseListMap);
    }

    //Read all employees
    @GetMapping("/employees")
    public EmployeeWrapper getEmployees() {
        Map<String, List<Employee>> responseListMap = new HashMap<>();
        responseListMap.put("query", employeeRepository.findAll());

        return new EmployeeWrapper(responseListMap);
    }

    //Read employee
    @GetMapping("/employee/{id}")
    public EmployeeWrapper getEmployee(@PathVariable(value = "id") String id) {
        Map<String, List<Employee>> responseListMap = new HashMap<>();
        responseListMap.put("query", Collections.singletonList(employeeRepository.findById(id).get()));

        return new EmployeeWrapper(responseListMap);
    }

    //Update employee
    @PutMapping("/employee")
    public EmployeeWrapper updateRecord(@Valid @RequestBody Employee employee) {
        Map<String, List<Employee>> responseListMap = new HashMap<>();
        responseListMap.put("updated", Collections.singletonList(employeeRepository.save(employee)));

        return new EmployeeWrapper(responseListMap);
    }

    //Delete employee
    @DeleteMapping("/employee/{id}")
    public HttpStatus deleteEmployee(@PathVariable(value = "id") String id) {
        employeeRepository.deleteById(id);

        Map<String, List<Employee>> listMap = new HashMap<>();

        return HttpStatus.OK;
    }
}
