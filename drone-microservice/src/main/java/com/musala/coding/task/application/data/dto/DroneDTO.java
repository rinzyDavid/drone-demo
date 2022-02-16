package com.musala.coding.task.application.data.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;



public @Data class DroneDTO {
	
@NotNull(message = "Drone serial umber must not be empty")
@Max(value =100, message="Drone serial number must not be greater than {value} characters")
@JsonProperty(required = true)
@NotEmpty
@NotBlank
private String serialNumber;
	
	
@JsonProperty(required = true)
@NotEmpty
@NotBlank
private String droneModel;
	
	
@DecimalMax(value = "500", message =" Drone cannot carry more than {value} grams")
private Double maxWeight; // Maximum weight the drone can carry
	
@JsonProperty(required = true)
@NotEmpty
@NotBlank	
private Integer batteryLife; 
	
@JsonProperty(required = false)	
private String droneState; 
	
	
private Double currentWeight; 
	

}
