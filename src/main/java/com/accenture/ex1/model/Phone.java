package com.accenture.ex1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Phone{

	@JsonProperty("homePhone")
	private String homePhone;

	@JsonProperty("workPhone")
	private String workPhone;
}