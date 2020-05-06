package com.accenture.ex1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee{

	@JsonProperty("address")
	private Address address;

	@JsonProperty("phone")
	private Phone phone;

	@JsonProperty("contact")
	private Contact contact;

	@JsonProperty("id")
	private String id;

	@JsonProperty("position")
	private String position;
}