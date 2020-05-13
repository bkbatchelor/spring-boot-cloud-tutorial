package com.insidethesandbox.clientapp.model.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {


    @JsonProperty("_id")
    private String id;

    @JsonProperty("position")
    private String position;

    @JsonProperty("contact")
    private Contact contact;

    @JsonProperty("address")
    private Address address;

    @JsonProperty("phone")
    private Phone phone;

    public Employee(String id) {
        this.id = id;
    }

    @Getter
    @NoArgsConstructor
    public static class Wrapper {

        private Map<String, List<Employee>> responseList;

        public Wrapper(Map<String, List<Employee>> listMap) {
            this.responseList = listMap;
        }
    }


}