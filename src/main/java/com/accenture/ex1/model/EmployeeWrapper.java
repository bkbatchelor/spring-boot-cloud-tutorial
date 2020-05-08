package com.accenture.ex1.model;


import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class EmployeeWrapper {

    private List<Employee> employeeList;

    public EmployeeWrapper(Employee employee) {
        employeeList = Arrays.asList(employee);
    }

    public EmployeeWrapper(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
