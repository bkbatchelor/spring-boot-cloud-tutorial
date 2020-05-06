package com.accenture.ex1.controller;


import com.accenture.ex1.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
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
        return ResponseEntity.ok(new Employee(id));
    }

    //Update employee
    @PutMapping("/record/{id}")
    public ResponseEntity<Employee> updateRecord(@PathVariable(value = "id") String id){
        return ResponseEntity.ok(new Employee(id));
    }

    //Delete employee
    @DeleteMapping("/employee/{id}")
    public Map<String,String> deleteEmployee(@PathVariable(value = "id") String id) {
        Map<String, String> map = new HashMap<>();
        map.put("delete", "successful");
        return map;
    }
}
