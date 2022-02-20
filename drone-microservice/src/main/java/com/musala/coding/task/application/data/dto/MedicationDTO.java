package com.musala.coding.task.application.data.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

public @Data  class MedicationDTO {

@JsonProperty(required = false)
private Long id;
	
@JsonProperty(required = true)
@NotEmpty
@NotBlank
@Pattern(regexp = "^[a-zA-Z0-9.\\-\\/_ ]*$", message="Only numbers, letters, underscore and dash characters are allowed")
	private String name;
	
@JsonProperty(required = true)
@Max(value=500, message="Weight too heavy for drone")
private Double weight;
	
	
@JsonProperty(required = true)
@NotEmpty
@NotBlank
@Pattern(regexp = "^[A-Z0-9.\\-\\/_ ]*$", message="Only numbers, capital letters, underscore and dash characters are allowed")
private String code;
	
	
	private String image;

}
