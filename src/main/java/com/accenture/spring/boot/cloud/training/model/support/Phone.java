package com.accenture.spring.boot.cloud.training.model.support;

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