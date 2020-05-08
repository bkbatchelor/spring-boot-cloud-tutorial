package com.accenture.spring.boot.cloud.training.controller;


import com.accenture.spring.boot.cloud.training.model.employee.EmployeeModel;
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
    public EmployeeModel.EmployeeWrapper createEmployee(@Valid @RequestBody EmployeeModel employee) {
        Map<String, List<EmployeeModel>> responseListMap = new HashMap<>();
        responseListMap.put("created", Collections.singletonList(employeeRepository.save(employee)));

        return new EmployeeModel.EmployeeWrapper(responseListMap);
    }

    //Read all employees
    @GetMapping("/employees")
    public EmployeeModel.EmployeeWrapper getEmployees() {
        Map<String, List<EmployeeModel>> responseListMap = new HashMap<>();
        responseListMap.put("query", employeeRepository.findAll());

        return new EmployeeModel.EmployeeWrapper(responseListMap);
    }

    //Read employee
    @GetMapping("/employee/{id}")
    public EmployeeModel.EmployeeWrapper getEmployee(@PathVariable(value = "id") String id) {
        Map<String, List<EmployeeModel>> responseListMap = new HashMap<>();
        responseListMap.put("query", Collections.singletonList(employeeRepository.findById(id).get()));

        return new EmployeeModel.EmployeeWrapper(responseListMap);
    }

    //Update employee
    @PutMapping("/employee")
    public EmployeeModel.EmployeeWrapper updateRecord(@Valid @RequestBody EmployeeModel employee) {
        Map<String, List<EmployeeModel>> responseListMap = new HashMap<>();
        responseListMap.put("updated", Collections.singletonList(employeeRepository.save(employee)));

        return new EmployeeModel.EmployeeWrapper(responseListMap);
    }

    //Delete employee
    @DeleteMapping("/employee/{id}")
    public HttpStatus deleteEmployee(@PathVariable(value = "id") String id) {
        employeeRepository.deleteById(id);

        Map<String, List<EmployeeModel>> listMap = new HashMap<>();

        return HttpStatus.OK;
    }
}
