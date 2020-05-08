package com.accenture.ex1.model;


import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Getter
public class EmployeeWrapper {

    private List<Employee> employeeList;

    private Map<String, List<String>> employeeHash;

    public EmployeeWrapper(Employee employee) {
        employeeList = Collections.singletonList(employee);
    }

    public EmployeeWrapper(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public EmployeeWrapper(Map<String, List<String>> listMap) {
        this.employeeHash = listMap;
    }
}
