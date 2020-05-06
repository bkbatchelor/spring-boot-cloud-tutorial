package com.accenture.ex1;


import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {


    @PostMapping("/employee")
    public void createEmplyee()
    @GetMapping("/employees")
    public void getEmployees(){

    }

    @

    @PutMapping("/record/{id}")
    public void updateRecord(@PathVariable(value = "id") String id){

    }


}
