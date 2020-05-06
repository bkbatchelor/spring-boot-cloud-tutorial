package com.accenture.ex1.controller;


import com.accenture.ex1.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class EmployeeController {

    //Create employee
    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee){
        return null;
    }

    //Read employee
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployees(@PathVariable(value = "id") String id){
//        ResponseEntity.ok(Employee);
        return null;
    }

    //Update employee
    @PutMapping("/record/{id}")
    public ResponseEntity<Employee> updateRecord(@PathVariable(value = "id") String id){
        return null;
    }

    //Delete employee
    @DeleteMapping("/employee/{id}")
    public Map<String,String> deleteEmployee(@PathVariable(value = "id") String id){
        return null;
    }
}
