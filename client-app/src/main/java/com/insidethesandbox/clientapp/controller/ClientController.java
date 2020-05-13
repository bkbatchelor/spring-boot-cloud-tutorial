package com.insidethesandbox.clientapp.controller;

import com.insidethesandbox.clientapp.model.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping("/client-app")
public class ClientController {
    private RestTemplate restTemplate;

    @Autowired
    public ClientController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    //create employee
    @PostMapping("/employee")
    public Employee.Wrapper createEmployee(@Valid @RequestBody Employee employee) {
        HttpEntity<Employee> request = new HttpEntity<>(employee);
        return restTemplate.exchange("http://localhost:8081/employee-service/employee", HttpMethod.POST, request, Employee.Wrapper.class).getBody();
    }


    //get all employee
    @GetMapping("/employees")
    public Employee.Wrapper getEmployees() {
        return restTemplate.getForObject("http://localhost:8081/employee-service/employees", Employee.Wrapper.class);
    }

    //get employee by id

    //Update employee by id

    // Delete employee by id
}
