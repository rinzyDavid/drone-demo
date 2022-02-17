package com.musala.coding.task.application.data.dto;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

public @Data class DroneActivityDTO {
	
	@NotNull(message = "Drone serial umber must not be empty")
	@Max(value =100, message="Drone serial number must not be greater than {value} characters")
	@JsonProperty(required = true)
	@NotEmpty
	@NotBlank
	private String serialNumber;
	
	private String droneModel;
	
	@JsonProperty(required = false)	
	private String droneState; 

	@JsonProperty(required = true)
	@NotEmpty(message="Quantity must not be empty")
	@NotBlank
	
	private Integer quantity;
	
	@JsonProperty(required = true)
	@NotEmpty(message="Total weight must not be empty")
	@NotBlank
	private Double totalWeight;

	private String deliveryAddress;
	
	@JsonProperty(required = true)
	@NotEmpty(message="Add medications before loading to drone")
	private List<MedicationDTO> medications;
}
