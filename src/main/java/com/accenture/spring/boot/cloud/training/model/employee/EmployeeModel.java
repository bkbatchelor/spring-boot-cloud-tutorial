package com.accenture.spring.boot.cloud.training.model.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employee")
public class EmployeeModel {

    @Id
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

    public EmployeeModel(String id) {
        this.id = id;
    }

    @Getter
    public static class EmployeeWrapper {

        private Map<String, List<EmployeeModel>> responseList;

        public EmployeeWrapper(Map<String, List<EmployeeModel>> listMap) {
            this.responseList = listMap;
        }
    }


}