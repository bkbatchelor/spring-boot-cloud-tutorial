package com.insidethesandbox.spring.boot.cloud.model.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Phone{

	@JsonProperty("homePhone")
	private String homePhone;

	@JsonProperty("workPhone")
	private String workPhone;
}