package com.accenture.spring.boot.cloud.training.model;


import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class EmployeeWrapper {

    private Map<String, List<Employee>> responseList;

    public EmployeeWrapper(Map<String, List<Employee>> listMap) {
        this.responseList = listMap;
    }
}
