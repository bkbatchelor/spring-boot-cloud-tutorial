package com.accenture.ex1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employee")
public class Employee {

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

	public Employee(String id) {
		this.id = id;
	}
}