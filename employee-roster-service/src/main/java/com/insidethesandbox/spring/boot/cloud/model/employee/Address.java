package com.insidethesandbox.spring.boot.cloud.model.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address{

	@JsonProperty("zipcode")
	private String zipcode;

	@JsonProperty("address")
	private String address;

	@JsonProperty("city")
	private String city;

	@JsonProperty("state")
	private String state;
}