package com.accenture.spring.boot.cloud.training.model;

import com.accenture.spring.boot.cloud.training.model.support.Address;
import com.accenture.spring.boot.cloud.training.model.support.Contact;
import com.accenture.spring.boot.cloud.training.model.support.Phone;
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

	//TODO override hashcode and equals
}